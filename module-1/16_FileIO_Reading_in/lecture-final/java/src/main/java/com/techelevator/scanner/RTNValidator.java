package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// What color is the sky?|Green|Blue*|Yellow

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
//				if (line.length() < 9) {
//					System.out.println("Line too short error");
//				}
//				else {

					String rtn = null;
					try {
						rtn = line.substring(0, 9);
						if (checksumIsValid(rtn) == false) {
							System.out.println(line);
						}
					} catch (NumberFormatException e) {
						System.out.println("ERROR: " + rtn + " has non-numerics");
					} catch (StringIndexOutOfBoundsException e) {
						System.out.println("ERROR: " + line + " is too short");
					}
//				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File " + inputFile.getName() + " does not exist");
		}

//		Scanner fileScannerOld = null;
//		try {
//			// Code to create a new Scanner...
//
//			// Code that might throw an exception...
//		}
//		catch (Exception e) {
//			// ...
//		}
//		finally {
//			if (fileScannerOld != null) {
//				fileScannerOld.close();
//			}
//		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	//@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
//		if(inputFile.exists() == false) { // checks for the existence of a file
//			System.out.println(path+" does not exist");
//			System.exit(1); // Ends the program
//		} else if(inputFile.isFile() == false) {
//			System.out.println(path+" is not a file");
//			System.exit(1); // Ends the program
//		}
		return inputFile;
	}

	/**
	 * Returns whether or not routingNumber is well formed
	 * @param routingNumber The routing number
	 * @return true or false
	 * @throws NumberFormatException when routingNumber contains non-numeric chars
	 */
	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
