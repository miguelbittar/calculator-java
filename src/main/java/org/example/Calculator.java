package org.example;

public class Calculator {
    private final Addition addition = new Addition();
    private final Subtraction subtraction = new Subtraction();
    private final Multiplication multiplication = new Multiplication();
    private final Division division = new Division();
    Operation operation;

    public double processExpression(String expression){
        try {
            expression = expression.replace(',','.') ;
            expression = expression.replaceAll("\\s+","");
            expression = expression.replaceAll("([+\\-*/])", " $1 ");
            String[] parts = expression.split(" ");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid format. Use: number operator number");
            }

            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            switch (operator) {
                case "+":
                    operation = addition;
                    break;
                case "-":
                    operation = subtraction;
                    break;
                case "*":
                    operation = multiplication;
                    break;
                case "/":
                    operation = division;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
            return operation.calculate(num1, num2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers. Use decimal numbers only");
        }
    }
}