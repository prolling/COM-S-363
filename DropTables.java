import java.sql.*;
public class DropTables {
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
		// drop major table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("Drop Table if exists major;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// drop minor table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("Drop table if exists minor;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// drop degree table
		try {
			stmt = connect.createStatement();
			stmt.addBatch(
					"Drop Table if exists degrees;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// drop register table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("Drop Table if exists register;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// drop courses table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("Drop Table if exists courses;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// drop students table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("Drop Table if exists students;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// drop departments table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("Drop Table if exists departments;");
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
