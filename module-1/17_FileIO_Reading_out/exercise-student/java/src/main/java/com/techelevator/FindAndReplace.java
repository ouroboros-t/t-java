package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        //ask for word to search for
        //ask for word to replace search word
        //ask for source file
        //ask for destination file
        //logic.do
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Please input word to search for");
            String wordToSearch = userInput.nextLine();
            if (wordToSearch.isEmpty() || wordToSearch == null) {
                System.out.println("ERROR: Given input invalid. Do better.");
                System.exit(0);
            }
            System.out.println("Please input word to replace");
            String replaceWord = userInput.nextLine();
            if (replaceWord.isEmpty() || replaceWord == null) {
                System.out.println("ERROR: Given input invalid. Do better.");
                System.exit(0);
            }
            System.out.println("Please input qualified folder path >>>>  ");
            String path = userInput.nextLine();
            File sourceFile = new File(path);
            if (!sourceFile.exists()) {
                System.out.println("Error: " + path + " no file found.");
                System.exit(0);
            } else if (!sourceFile.isFile()) {
                System.out.println("You really need a file here.");
                System.exit(0);
            }
            System.out.println("Please input a qualified destination folder path >>> ");
            path = userInput.nextLine();
            File destinationFile = new File(path);
            if (!destinationFile.exists()) {
                System.out.println("Error: " + path + " no file found.");
                System.exit(0);
            }
            if (!destinationFile.getName().endsWith(".txt")) {
                System.out.println("Destination file MUST be a text (.txt) file.");
                System.exit(0);
            }
            //do logic:
            try (Scanner readSourceFile = new Scanner(sourceFile.getAbsoluteFile());
                 PrintWriter printWriterDestination = new PrintWriter(destinationFile.getAbsoluteFile())) {
                //take the search word
                //take the replace word
                //swap them
                while (readSourceFile.hasNextLine()) {
                    String line = readSourceFile.nextLine();
                    printWriterDestination.println(line.replaceAll(wordToSearch, replaceWord));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}


