package com.techelevator;

public class HomeworkApp {
    public static void main(String[] args) {
        HomeworkAssignment newHomework = new HomeworkAssignment(500, "Tay");
        System.out.println(newHomework.getSubmitterName() + " can have a total of " + newHomework.getPossibleMarks() + " points." );

        newHomework.setEarnedMarks(246);
        System.out.println("If " + newHomework.getSubmitterName()+ " has " + newHomework.getEarnedMarks()+ " points...");


        //grammar matters...
        if(newHomework.getLetterGrade().equals("A") || newHomework.getLetterGrade().equals("F")){
            System.out.printf("Then Tay has an " + newHomework.getLetterGrade() + "!");
        } else {
            System.out.println("Then " + newHomework.getSubmitterName() + " has a " + newHomework.getLetterGrade() + "!");
        }
        System.out.println();
        System.out.println(newHomework.reportCard());







    }
}
