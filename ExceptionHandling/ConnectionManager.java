package ExceptionHanding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements AutoCloseable {
    private Connection connection;

    public ConnectionManager(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (ConnectionManager manager = new ConnectionManager(url, user, password)) {
            Connection conn = manager.getConnection();
            // Use the connection here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

