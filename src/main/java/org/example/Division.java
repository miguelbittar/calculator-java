package org.example;

public class Division implements Operation{

    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = a / b;
        return result;
    }
}