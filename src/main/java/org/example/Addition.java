package org.example;

public class Addition implements Operation{

    @Override
    public double calculate(double a, double b){
        double result = a + b;
        return result;
    }
}
