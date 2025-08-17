package org.example;
import java.util.Scanner;

public class ConsoleInterface{
    private Scanner scanner;
    private Calculator calculator;
    private OperationRepository repository;

    public ConsoleInterface(){
        this.scanner = new Scanner(System.in);
        this.calculator = new Calculator();
        this.repository = new DatabaseManager();
        this.repository.createTable();
    }

    public String readInput(){
        return scanner.nextLine();
    }

    public void runLoop(){
        while(true) {
            showMenu();
            String input = readInput();

            if(input.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if(input.equalsIgnoreCase("h")){
                repository.showHistory();
                continue;
            }

            if (input.equalsIgnoreCase("clear")) {
                repository.clearHistory();
                continue;
            }

            try {
                double result = calculator.processExpression(input);
                repository.saveOperation(input, result);
                displayResult(result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    public void showMenu(){
        System.out.println("\n=== CALCULATOR ===");
        System.out.println("Enter expression (example: 5 + 3)");
        System.out.println("Type 'h' to view history");
        System.out.println("Type 'clear' to clear history");
        System.out.println("Type 'exit' to quit");
        System.out.print("> ");
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}