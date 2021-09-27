package com.techelevator.calculator;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        CalculatorApp calculatorApp = new CalculatorApp();
        calculatorApp.run();
    }

    public void run() {
        System.out.println("Welcome to the Simple Calculator. This calculator adds two integers");

        Scanner userInputScanner = new Scanner(System.in);

        // These two chunks of code are very similar. Can be refactored into the method getIntFromUser
//        System.out.println("Please enter the first number to add: ");
//        String firstValueStr = userInputScanner.nextLine();
//        int firstValue = Integer.parseInt(firstValueStr);
//        System.out.println("You entered " + firstValue);
//        System.out.println();
//
//        System.out.println("Please enter the second number to add: ");
//        String secondValueStr = userInputScanner.nextLine();
//        int secondValue = Integer.parseInt(secondValueStr);
//        System.out.println("You entered " + secondValue);
//        System.out.println();

        int firstValue = getIntFromUser("Please enter the first number to add: ", userInputScanner);
        int secondValue = getIntFromUser("Please enter the second number to add: ", userInputScanner);

        int result = firstValue + secondValue;
        System.out.println(firstValue + " + " + secondValue + " = " + result);
    }

    private int getIntFromUser(String prompt, Scanner inputScanner) {
        System.out.print(prompt);
        String valueStr = inputScanner.nextLine();
        int value = Integer.parseInt(valueStr);
        System.out.println("You entered " + value);
        System.out.println();

        return value;
    }
}
