package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //system.in is the stream of data telling scanner to read from keyboard inputs

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percent sign): ");
        String discountAmountStr = scanner.nextLine();
        double discountAmount = Double.parseDouble(discountAmountStr);
        discountAmount /= 100.0;//you don't need to have the .0, because it's en implicit conversion.
        //System.out.println("You entered " + discountAmount + "%")


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesStr = scanner.nextLine(); //nextLine ALWAYS gives us back a string
        String[] pricesStrs = pricesStr.split(" ");
        //.split return multiple strings for the input we're asking for.
        //in this case, the input from pricesStr will return multiple strings
        for (int i = 0; i < pricesStrs.length; i++) {
            //System.out.println(priceStrs[i]);
            double price = Double.parseDouble(pricesStrs[i]);
            //we now are turning the string into a double

            double priceDiscount = price * discountAmount;

            double priceAfterDiscount = price - priceDiscount;

            //System.out.println("Price: " +price +" Discount: " + priceDiscount + " Final Price: " + priceAfterDiscount);
            System.out.format("Price: $%1.2f Discount: $%1.2f%n", price, priceDiscount );
            //this says to print: (Price: $, 2 spaces after decimal,
            //the number of formats you have (string format) has to match the number of (obj .. args)
        }






    }

}