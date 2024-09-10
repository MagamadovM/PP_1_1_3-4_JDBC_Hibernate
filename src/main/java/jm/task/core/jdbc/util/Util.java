package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection;

    private Util() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/new_schema";
                String user = "root";
                String password = "41586372";


                Class.forName("com.mysql.cj.jdbc.Driver");


                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            System.err.println("Ошибка загрузки драйвера JDBC: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                System.err.println("Ошибка закрытия соединения: " + e.getMessage());
            }
        }
    }
}