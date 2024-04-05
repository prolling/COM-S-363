
import java.sql.*;

public class CreateTables {
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
		// create the students table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE students (\r\n" + "	snum INT,\r\n" + "	ssn INTEGER,\r\n"
					+ "    name VARCHAR(10),\r\n" + "    gender VARCHAR(1),\r\n" + "    dob DATE, \r\n"
					+ "    c_addr VARCHAR(20),\r\n" + "    c_phone VARCHAR(10),\r\n" + "    p_addr VARCHAR(20),\r\n"
					+ "    p_phone VARCHAR(10),\r\n" + "    PRIMARY KEY(ssn),\r\n" + "    UNIQUE(snum)\r\n" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create the departments table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE departments (\r\n" + "	code INT,\r\n" + "	name VARCHAR(50),\r\n"
					+ "    phone VARCHAR(10),\r\n" + "    college VARCHAR(20),\r\n" + "    PRIMARY KEY(code)\r\n"
					+ ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create the degrees table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE degrees (\r\n" + "	name VARCHAR(50),\r\n" + "	level VARCHAR(5),\r\n"
					+ "    department_code INT NOT NULL,\r\n"
					+ "    FOREIGN KEY (department_code) REFERENCES departments(code) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    PRIMARY KEY (name, level)\r\n" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create the courses table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE courses (\r\n" + "	number INT,\r\n" + "	name varchar(50) UNIQUE,\r\n"
					+ "    descrption varchar(50),\r\n" + "    credithours INT,\r\n" + "    level varchar(20),\r\n"
					+ "    department_code int NOT NULL,\r\n"
					+ "    FOREIGN KEY (department_code) REFERENCES departments(code) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    PRIMARY KEY (number)\r\n" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create the register table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE register (\r\n" + "	snum INT,\r\n" + "	course_number INT,\r\n"
					+ "    regtime VARCHAR(20),\r\n" + "    grade INT,\r\n"
					+ "    FOREIGN KEY (snum) REFERENCES students(snum) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    FOREIGN KEY (course_number) REFERENCES courses(number) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    PRIMARY KEY(snum, course_number)\r\n" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create the major table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE major (\r\n" + "	snum INT,\r\n" + "	name VARCHAR(50),\r\n"
					+ "    level VARCHAR(5),\r\n"
					+ "    FOREIGN KEY (snum) REFERENCES students(snum) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    FOREIGN KEY (name, level) REFERENCES degrees(name, level) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    PRIMARY KEY(snum, name, level)\r\n" + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create the minor table
		try {
			stmt = connect.createStatement();
			stmt.addBatch("CREATE TABLE minor (\r\n" + "	snum INT,\r\n" + "	name VARCHAR(50),\r\n"
					+ "    level VARCHAR(5),\r\n"
					+ "    FOREIGN KEY (snum) REFERENCES students(snum) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    FOREIGN KEY (name, level) REFERENCES degrees(name, level) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
					+ "    PRIMARY KEY(snum, name, level)\r\n" + ");");

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