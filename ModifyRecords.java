import java.sql.*;

public class ModifyRecords {
	private static Connection connect = null;

	public static void main(String[] args) {

		try {
			// Set up connection parameters
			String userName = "coms363";
			String password = "password";
			String dbServer = "jdbc:mysql://localhost:3306/project1";
			// String dbServer = "jdbc:mysql://mysql.cs.iastate.edu/[schema]";
			// Set up connection
			connect = DriverManager.getConnection(dbServer, userName, password);
		} catch (Exception e) {

		}

		Statement stmt = null;
		// turn off safe updates
		try {
			stmt = connect.createStatement();
			stmt.addBatch("set sql_safe_updates = 0;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Change the name of the student with ssn = 746897816 to Scott
		try {
			stmt = connect.createStatement();
			stmt.addBatch("update students set name = 'Scott' where ssn = 746897816;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Change the major of the student with ssn = 746897816 to Computer Science,
		// Master.
		try {
			stmt = connect.createStatement();
			stmt.addBatch(
					"update major set name = 'Computer Science', level = 'MS' where snum in (select snum from students where ssn = 746897816);");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Delete all registration records that were in “Spring2021”
		try {
			stmt = connect.createStatement();
			stmt.addBatch("delete from register where regtime = 'Spring2021';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// turn on safe updates
		try {
			stmt = connect.createStatement();
			stmt.addBatch("set sql_safe_updates = 1;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// close the connection
		finally {
			try {
				// Close connection
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
