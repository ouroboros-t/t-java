package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.print("Please input file path to search through: ");
        String path = userInput.nextLine();

        File inputFile = new File(path);


        try (Scanner userFile = new Scanner(inputFile)) {
            int lineCount = 1;
            String inputWordToSearch = null;
            String casing = null;
            boolean caseMatters = false;
            try {
                System.out.println("What word do you want to search for?");
                 inputWordToSearch = userInput.nextLine();
                 if(inputWordToSearch.equals("")){
                     System.out.println("Please input a word.");
                     System.exit(1);
                 }
            } catch(NullPointerException e){
                System.out.println("You need to put in a word here...");
            }
            try{
                System.out.println("Should the search be case-sensitive? (Y\\N)");
                casing = userInput.nextLine();
                if(casing.equals("Y") || casing.equals("y")) {
                    caseMatters = true;
                } else if (casing.equals("N")|| casing.equals("n")){
                    caseMatters = false;
                } else {
                    System.out.println("Please enter a Y or an N");
                    System.exit(0);
                }
            } catch(NullPointerException e){
                System.out.println("Please enter a Y or an N");
            }
            while (userFile.hasNext()) {
                String lineOfInput = userFile.nextLine();
                if(caseMatters) {
                    if (lineOfInput.contains(inputWordToSearch)) {
                        System.out.println(lineCount + ":  " + lineOfInput);
                    }
                } else{
                    if(lineOfInput.toLowerCase().contains(inputWordToSearch.toLowerCase())){
                        System.out.println(lineCount + ":  " + lineOfInput);
                    }
                }
                lineCount++;
            }
        }catch(NullPointerException e){
            System.out.println("ERROR. Please try again.");
            System.exit(0);
        } catch(FileNotFoundException e) {
			System.out.println("This file does not exist. Please try again.");
		}
    }

}
