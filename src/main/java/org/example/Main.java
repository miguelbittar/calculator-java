package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting calculator...");
        ConsoleInterface console = new ConsoleInterface();
        console.runLoop();
        System.out.println("Calculator closed.");
    }
}