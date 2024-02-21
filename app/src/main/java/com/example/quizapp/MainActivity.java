package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuizAdapter adapter;
    private ArrayList<Question> questions;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch the hardcoded electrophysics questions
        questions = new ArrayList<>(QuestionUtils.getElectrophysicsQuestions());

        // Set up the adapter and attach it to the RecyclerView
        adapter = new QuizAdapter(questions);
        recyclerView.setAdapter(adapter);

        // Initialize the submit button
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate and display the score when the submit button is clicked
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        int totalQuestions = questions.size();
        int correctAnswers = 0;

        // Iterate through the questions to count how many correct answers were selected
        for (int i = 0; i < totalQuestions; i++) {
            Question question = questions.get(i);
            int selectedAnswerIndex = adapter.getSelectedAnswerIndex(i);

            if (selectedAnswerIndex == question.getAnswerIndex()) {
                correctAnswers++;
            }
        }

        // Calculate the score and display it using a Toast
        double score = ((double) correctAnswers / totalQuestions) * 100;
        String resultMessage = "You scored " + correctAnswers + " out of " + totalQuestions + ".\n" +
                "Your percentage: " + String.format("%.2f", score) + "%";

        Toast.makeText(MainActivity.this, resultMessage, Toast.LENGTH_LONG).show();
    }
}
