package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Update these based on your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/tripsolo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Amitesh@7100";  // <-- change this

    private static Connection connection;

    // Private constructor to prevent object creation
    private DBConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println(" Connected to MySQL database successfully.");
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            }
        }
        return connection;
    }
}
