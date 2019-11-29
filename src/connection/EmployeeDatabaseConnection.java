package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    // for establishing connection
    public static boolean attemptConnection() {
        boolean isConnected = false;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                isConnected = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return isConnected;
    }

    // for checking whether connection is closed or not
    public boolean isConnectionClosed() {
        boolean connectionClosed = false;
        try {
            getConnection().close();
            connectionClosed = true;
        } catch (SQLException e) {
            System.out.println("Connection not closed");
        }
        return connectionClosed;
    }
}

