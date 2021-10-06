package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */
		File pwd = new File(".");
		System.out.println(pwd.getAbsolutePath());
		File unsorted = new File ("unsorted.txt");
		System.out.println("Exists? " + unsorted.exists());
		System.out.println(("Length: " + unsorted.length()));

		try(Scanner unsortedScanner = new Scanner(unsorted);
		PrintWriter sortedWriter = new PrintWriter("sorted.txt");
		//file writer does not need separate check to see if file exists, will just create the new needed file.
		PrintWriter appendingSortedWriter = new PrintWriter(new FileWriter("appendSorted.txt",true))){

			readSortAndPrint(unsortedScanner, sortedWriter);

//			// Read the unsorted line into a List<String>
//			List<String> lines = new ArrayList<String>();
//			while (unsortedScanner.hasNextLine()){
//				String line = unsortedScanner.nextLine();
//				lines.add(line);
//			}
//			//sort the list:
//			Collections.sort(lines);
//
//			//print to the file
//			for(String line : lines){
//				sortedWriter.println(line);
//			}
//			//try with resources closes the file for us.
//			//can only overwrite or add new objects at the end with append..
//			//Write the lines to appendingSortWriter
//			for(String line : lines){
//				appendingSortedWriter.println(line);
//				//this new file will have what we originally had in sorted.txt PLUS what we added to unsorted..
//			}
			//.Flush sometimes comes up...it's inefficient and slow for memory
		}


	}

	public static void readSortAndPrint(Scanner unsortedScanner, PrintWriter sortedWriter){
		// Read the unsorted line into a List<String>
		List<String> lines = new ArrayList<String>();
		while (unsortedScanner.hasNextLine()){
			String line = unsortedScanner.nextLine();
			lines.add(line);
		}
		//sort the list:
		Collections.sort(lines);

		//print to the file
		for(String line : lines){
			sortedWriter.println(line);
		}

	}


}
