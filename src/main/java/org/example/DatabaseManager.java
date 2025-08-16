package org.example;
import java.sql.*;

public class DatabaseManager implements OperationRepository{

    @Override
    public void createTable(){
        try(Connection connection = ConnectionDB.getConnection();
            Statement stmt = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS operations (" +
                    "id INTEGER PRIMARY KEY, " +
                    "expression TEXT NOT NULL, " +
                    "result REAL NOT NULL, " +
                    "created_at DATETIME DEFAULT CURRENT_TIMESTAMP)";

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void saveOperation(String expression, double result) {
        String sql = "INSERT INTO operations (expression, result) VALUES (?,?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, expression);
            stmt.setDouble(2, result);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving operation: " + e.getMessage());
        }
    }

    @Override
    public void showHistory(){
        String sql = "SELECT * FROM operations ORDER BY created_at DESC";
        try(Connection connection = ConnectionDB.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== OPERATION HISTORY ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String expression = rs.getString("expression");
                double result = rs.getDouble("result");
                String date = rs.getString("created_at");

                System.out.println(id + ". " + expression + " = " + result + " (" + date + ")");
            }
            System.out.println("========================\n");
        } catch (SQLException e) {
            System.out.println("Error reading history: " + e.getMessage());
        }
    }

    @Override
    public void clearHistory(){
        try(Connection connection = ConnectionDB.getConnection();
            Statement stmt = connection.createStatement()) {

            String sql = "DELETE FROM operations";
            stmt.executeUpdate(sql);

            System.out.println("History cleared!");
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error clearing history: " + e.getMessage());
        }
    }
}