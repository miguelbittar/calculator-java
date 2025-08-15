package org.example;

public class Subtraction implements  Operation{

    @Override
    public double calculate(double a, double b){
        double result = a - b;
        return result;
    }
}