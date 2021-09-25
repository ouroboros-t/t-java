package com.techelevator;

public class HomeworkAssignment {
    //what properties of class:
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    //Derived property, getter with no setter:
    public String getLetterGrade(){
        double earnedMarksDouble = this.earnedMarks * 1.0;
        double possibleMarksDouble = this.possibleMarks * 1.0;
        double letterGrade = earnedMarksDouble /possibleMarksDouble;
        //do I need to use getEarnedMarks method here?
        String finalLetterGrade = null;
        if((letterGrade <= .59) ) {
            finalLetterGrade = "F";
        } else if (letterGrade <= .69){
           finalLetterGrade = "D";
            System.out.println("You failed! :(");
        }  else if(letterGrade <= .79){
            finalLetterGrade = "C";
        } else if (letterGrade <= .89) {
            finalLetterGrade = "B";
        } else if (letterGrade >= .90) {
            finalLetterGrade = "A";
        }
        return finalLetterGrade;


        //CONSTRUCTOR:
    }
    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;

        //GETTERS && SETTERS:
    }
    public int getEarnedMarks() {
        return this.earnedMarks;
    }
    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks(){
        return this.possibleMarks;
    }

    public String getSubmitterName(){
        return this.submitterName;
    }

    public String reportCard () {
        String reportCard = "Submitted By: " + submitterName + "\nPoints Earned: " + earnedMarks + " Points Possible: " + possibleMarks
                + "\nFinal Grade: " + getLetterGrade();
        return reportCard;
    }


}
