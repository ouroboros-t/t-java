package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		//get file
		//get destination file
		//for loop while i <=300
		//counter
		//print to destination file
		try(Scanner userInput = new Scanner(System.in)) {
			System.out.println("Please input a qualified destination folder path >>> ");
			String path = userInput.nextLine();
			File destinationFile = new File(path);
			if(path.isEmpty() || path == null){
				System.out.printf("The file is empty. Please fix. ");
				System.exit(0);
			}
			if (!destinationFile.getName().endsWith(".txt")) {
				System.out.println("Destination file MUST be a text (.txt) file.");
				System.exit(0);
			}
			try(PrintWriter printWriterDestination = new PrintWriter(destinationFile.getAbsoluteFile())){
				for(int i = 1; i <= 300; i++){
					if(i % 3 == 0 && i % 5 == 0){
						printWriterDestination.println("FizzBuzz");
					} else if( i % 5 == 0) {
						printWriterDestination.println("Buzz");
					} else if (i % 3 == 0){
						printWriterDestination.println("Fizz");
					} else {
						printWriterDestination.println(i);
					}
				}

			}catch(FileNotFoundException e){
				System.out.println("File" + path + "not found");
				System.exit(0);
			}


		}catch(Exception e){
			System.out.println("Not allowed. ");
			System.exit(0);

		}






	}

}
