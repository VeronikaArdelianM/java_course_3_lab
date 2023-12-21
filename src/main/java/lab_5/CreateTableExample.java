package lab_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {

    public static void main(String[] args) {
        // Replace these values with your actual database credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/school";
        String username = "nika";
        String password = "veronika09";

        // JDBC variables
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute SQL statements to create tables
            String createTeacherTableSQL = "CREATE TABLE Teacher (" +
                    "teacherId INT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL)";

            String createStudentTableSQL = "CREATE TABLE Student (" +
                    "studentId INT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL)";

            String createSchoolTableSQL = "CREATE TABLE School (" +
                    "schoolId INT PRIMARY KEY," +
                    "FOREIGN KEY (teacherId) REFERENCES Teacher(teacherId)," +
                    "FOREIGN KEY (studentId) REFERENCES Student(studentId))";

            // Execute SQL statements
            statement.executeUpdate(createTeacherTableSQL);
            statement.executeUpdate(createStudentTableSQL);
            statement.executeUpdate(createSchoolTableSQL);

            System.out.println("Tables created successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
