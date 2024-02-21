package com.example.quizapp;

import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> options;
    private int answerIndex;

    public Question(String questionText, ArrayList<String> options, int answerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}
