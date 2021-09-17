package com.techelevator;
import java.util.Scanner;
public class TempConvert {
//The Fahrenheit to Celsius conversion formula is: Tc = (Tf - 32) / 1.8;
	// The Celsius to Fahrenheit conversion formula is:Tf = Tc * 1.8 + 32
	public static void main(String[] args) {
		System.out.println("Temp Converter: Fahrenheit & Celsius");
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please enter a number: "); //ask user for input degree number
		String  degreeNumStr = scanner.nextLine(); // turn input into readable string
		double degreeNum = Double.parseDouble(degreeNumStr); // turn string into double because the math requires decimals.

		System.out.println("Indicate type: \"F\" for Fahrenheit or \"C\" for Celsius "); //ask user to input whether or not F or C
		String  degreeTypeStr = scanner.nextLine(); //turn input into readable string
			if(degreeTypeStr.equals("F")) {
				degreeNum = ((degreeNum - 32) / 1.8);
				int degreeInC = (int)degreeNum;
				System.out.println(degreeNumStr + " degrees Fahrenheit is " + degreeInC + " degrees in Celsius!");
			} else if (degreeTypeStr.equals("C")) {
				degreeNum = degreeNum * 1.8 + 32;
				int degreeInF = (int)degreeNum;
				System.out.println(degreeNumStr + " degrees Celsius is " + degreeInF + " degrees in Fahrenheit!");
			}

	}

}
