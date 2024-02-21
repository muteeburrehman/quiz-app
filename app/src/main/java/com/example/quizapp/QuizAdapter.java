package com.example.quizapp;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuestionViewHolder> {

    private ArrayList<Question> questions;
    // SparseArray to keep track of the selected options for each question
    private SparseArray<Integer> selectedAnswers = new SparseArray<>();

    public QuizAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Question question = questions.get(position);
        holder.questionTextView.setText(question.getQuestionText());
        holder.answersGroup.removeAllViews(); // Clear previous answers

        // Rebuilding the radio buttons for the current question
        for (int i = 0; i < question.getOptions().size(); i++) {
            RadioButton radioButton = new RadioButton(holder.answersGroup.getContext());
            radioButton.setText(question.getOptions().get(i));
            radioButton.setId(View.generateViewId());

            final int answerIndex = i;
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // When an option is selected, store the selection
                    selectedAnswers.put(position, answerIndex);
                }
            });

            holder.answersGroup.addView(radioButton);

            // Check if this radio button is the selected answer for the current question
            if (selectedAnswers.get(position, -1) == answerIndex) {
                holder.answersGroup.check(radioButton.getId());
            }
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public int getSelectedAnswerIndex(int position) {
        return selectedAnswers.get(position, -1); // Return -1 if no selection has been made
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView;
        RadioGroup answersGroup;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            answersGroup = itemView.findViewById(R.id.answersGroup);
        }
    }
}
