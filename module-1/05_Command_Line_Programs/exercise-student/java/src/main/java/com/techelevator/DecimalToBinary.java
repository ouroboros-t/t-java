package com.techelevator;

import java.util.Scanner;
//mod 2 each part of the number so 49 will return 4

public class DecimalToBinary {
//HOW do I convert to Binary in the first place?!
	public static void main(String[] args) {
		System.out.println("I’ve got 1100011 problems…but converting to binary isn't one!");
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter a number here: ");
		String binaryIntStr = scanner.nextLine();
		int binaryInt = Integer.parseInt(binaryIntStr);
		System.out.println(Integer.toBinaryString(binaryInt));
	}

}
