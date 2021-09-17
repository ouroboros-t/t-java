package com.techelevator;
import java.util.Scanner;
public class LinearConvert {

	public static void main(String[] args) {
		System.out.println("Converting Lengths feat. Meters & Feet");
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please enter a number: "); //ask user for input length number
		String  lengthNumStr = scanner.nextLine(); // turn input into readable string
		double lengthNum = Double.parseDouble(lengthNumStr); // turn string into double because the math requires decimals.

		System.out.println("Indicate length type: \"F\" for Feet or \"M\" for Meters "); //ask user to input whether or not F or M
		String  degreeTypeStr = scanner.nextLine(); //turn input into readable string
		if(degreeTypeStr.equals("F")) {
			lengthNum = lengthNum * 0.3048;
			int lengthInMeters = (int)lengthNum;
			System.out.println(lengthNumStr + " in feet is " + lengthInMeters + " in meter!");
		} else if (degreeTypeStr.equals("M")) {
			lengthNum = lengthNum  * 3.2808399;
			int lengthInFeet = (int)lengthNum;
			System.out.println(lengthNumStr + " meters is " + lengthInFeet + " feet!");
		}
	}

}
