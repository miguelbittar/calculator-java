package org.example;

public interface OperationRepository {
    void saveOperation(String expression, double result);
    void showHistory();
    void clearHistory();
    void createTable();
}
