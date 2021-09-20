package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percent sign): ");
        String discountAmountStr = scanner.nextLine();
        double discountAmount = Double.parseDouble(discountAmountStr);
        discountAmount /= 100.0;
        //System.out.println("You entered " + discountAmount);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesStr = scanner.nextLine();

        String[] priceStrs = pricesStr.split(" ");

        for (int i = 0; i < priceStrs.length; i++) {
            //System.out.println(priceStrs[i]);
            double price = Double.parseDouble(priceStrs[i]);

            double priceDiscount = price * discountAmount;

            double priceAfterDiscount = price - priceDiscount;

            //System.out.println("Price: " + price + " Discount: " + priceDiscount + " Final price: " + priceAfterDiscount);

            //System.out.format("Price: $%9.2f Discount: $%9.2f %n", price, priceDiscount);
            System.out.format("Price: %9.2f", price);
            System.out.println();
        }
    }

}