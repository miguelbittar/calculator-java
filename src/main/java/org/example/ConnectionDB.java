package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL_JDBC_DEFAULT = "jdbc:sqlite:calculator_database.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_JDBC_DEFAULT);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database: " + e.getMessage());
        }
    }

    public static Connection getConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database: " + e.getMessage());
        }
    }
}