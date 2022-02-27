package com.example.bensflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView flashcardQuestion = findViewById(R.id.flashcard_question_textview);
        TextView flashcardAnswer = findViewById(R.id.flashcard_answer_textview);
        TextView choice1 = findViewById(R.id.choice_1);
        TextView choice2 = findViewById(R.id.choice_2);
        TextView correctChoice = findViewById(R.id.choice_correct);
        ImageView eyeIcon = findViewById(R.id.toggle_choices_visibility);

        flashcardQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardQuestion.setVisibility(View.INVISIBLE);
                flashcardAnswer.setVisibility(View.VISIBLE);
            }
        });

        flashcardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardAnswer.setVisibility(View.INVISIBLE);
                flashcardQuestion.setVisibility(View.VISIBLE);
            }
        });

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setBackgroundColor(getResources().getColor(R.color.red, null));
                correctChoice.setBackgroundColor(getResources().getColor(R.color.green, null));
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setBackgroundColor(getResources().getColor(R.color.red, null));
                correctChoice.setBackgroundColor(getResources().getColor(R.color.green, null));
            }
        });

        correctChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctChoice.setBackgroundColor(getResources().getColor(R.color.green, null));
            }
        });

        eyeIcon.setOnClickListener(new View.OnClickListener() {
            boolean isShowingAnswers = true;
            @Override
            public void onClick(View v) {
                if (isShowingAnswers) {
                    ((ImageView) findViewById(R.id.toggle_choices_visibility)).setImageResource(R.drawable.eye_off);
                    choice1.setVisibility(View.INVISIBLE);
                    choice2.setVisibility(View.INVISIBLE);
                    correctChoice.setVisibility(View.INVISIBLE);
                }
                else {
                    ((ImageView) findViewById(R.id.toggle_choices_visibility)).setImageResource(R.drawable.eye_on);
                    choice1.setVisibility(View.VISIBLE);
                    choice2.setVisibility(View.VISIBLE);
                    correctChoice.setVisibility(View.VISIBLE);
                }
                isShowingAnswers = !isShowingAnswers;
            }
        });
    }
}