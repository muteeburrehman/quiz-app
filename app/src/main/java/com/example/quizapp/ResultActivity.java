package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private double score;
    private ArrayList<Question> questions;
    private SparseArray<Integer> selectedAnswers;

    public ResultActivity() {
        // Default constructor with no arguments
    }

    public ResultActivity(double score, ArrayList<Question>
                          questions, SparseArray<Integer> selectedAnswers){
        this.score = score;
        this.questions = questions;
        this.selectedAnswers = selectedAnswers;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Extract data from Intent
        double score = getIntent().getDoubleExtra("score", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 0);

        // Display result
        calculateResult(score, totalQuestions);
    }

    private void calculateResult(double score, int totalQuestions) {
        int correctAnswers = (int) ((score / 100) * totalQuestions);

        String resultMessage = "You scored " + correctAnswers + " out of " + totalQuestions + ".\n" +
                "Your percentage: " + String.format("%.2f", score) + "%";

        // Display the resultMessage in your UI, e.g., using TextView
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(resultMessage);
    }
}