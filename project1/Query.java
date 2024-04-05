import java.sql.*;

public class Query {
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
		// The student number and ssn of the student whose name is "Becky"
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select snum, ssn from students where name = 'Becky';");
			while (rs.next()) {
				// display values
				System.out.println("snum: " + rs.getInt("snum"));
				System.out.println("ssn: " + rs.getInt("ssn"));
				//System.out.println(rs.getInt("snum") + ","+rs.getInt("snn"))
			}
			System.out.println(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// The major name and major level of the student whose ssn is 123097834
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select name, level from major where snum in (select snum from students where ssn = 123097834);");
			while (rs.next()) {
				// display values
				System.out.println("name: " + rs.getString("name"));
				System.out.println("level: " + rs.getString("level"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// The names of all courses offered by the department of Computer Science
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select distinct c.name from courses c, departments d where c.department_code = d.code and d.name = 'Computer Science';");
			while (rs.next()) {
				// display values
				System.out.println("name: " + rs.getString("name"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// All degree names and levels offered by the department Computer Science
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select distinct g.name, g.level from degrees g, departments d where g.department_code = d.code and d.name = 'Computer Science';");
			while (rs.next()) {
				// display values
				System.out.println("name: " + rs.getString("name"));
				System.out.println("level: " + rs.getString("level")); 
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// The names of all students who have a minor
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct s.name from students s, minor m where s.snum = m.snum;");
			while (rs.next()) {
				// display values
				System.out.println("name: " + rs.getString("name"));
			}
			System.out.println();
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
