package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the fully qualified name of the file to read in for quiz questions\n" +
                "here: ");
        String path = userInput.nextLine();
        File inputFile = new File(path);
        List<Question> quiz = new ArrayList<Question>();
        try (Scanner userFile = new Scanner(inputFile)) {

            while (userFile.hasNextLine()) {
                String line = userFile.nextLine();
                Question newQuestion = createQuestionFromLine(line);
                quiz.add(newQuestion);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        runQuiz(quiz);
    }

    public static Question createQuestionFromLine(String line) {
        String[] questionParts = line.split("\\|");
        Question question = new Question();
        question.setPrompt(questionParts[0]);
        List<String> alternatives = new ArrayList<String>();
        for (int i = 1; i < questionParts.length; i++) {
            if (questionParts[i].endsWith("*")) {
                question.setCorrectAnswer(i);
                alternatives.add(questionParts[i].substring(0, questionParts[i].length() - 1));
            } else {
                alternatives.add(questionParts[i]);
            }
        }
        question.setAnswers(alternatives);
        return question;
    }

    public static void runQuiz(List<Question> quiz) {
        int numCorrect = 0;

        Scanner userInput = new Scanner(System.in);
        for (Question quizParts : quiz) {
            int questionNum = 0;
            System.out.println(quizParts.getPrompt());
            for (String quizQuestion : quizParts.getAnswers()) {
                questionNum++;
                System.out.println(questionNum + ". " + quizQuestion);

            }
            System.out.print("Your answer: ");
            String userAnswerStr = userInput.nextLine();
            int userAnswer = Integer.parseInt(userAnswerStr);
            if (quizParts.getCorrectAnswer() == userAnswer) {
                numCorrect++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }

        }
        System.out.println("You got " + numCorrect + " answer(s) out of " + quiz.size() + " questions asked.");

    }

}
