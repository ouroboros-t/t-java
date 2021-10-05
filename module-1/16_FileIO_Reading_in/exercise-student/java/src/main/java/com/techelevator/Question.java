package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Question {
   private  String prompt;
   private List<String> answers;
   private  int correctAnswer;

   public Question(){

   }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getAnswers(){
       return answers;
    }
    public int getCorrectAnswer(){
       return correctAnswer;
    }

    public void setPrompt(String prompt){
       this.prompt = prompt;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
