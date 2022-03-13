package com.example.bensflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


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
        ImageView addCardButton = findViewById(R.id.add_button);
        ImageView editCardButton = findViewById(R.id.edit_button);

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
            boolean wrongChoiceClicked = true;
            @Override
            public void onClick(View v) {
                if (wrongChoiceClicked) {
                    choice1.setBackgroundColor(getResources().getColor(R.color.red, null));
                    correctChoice.setBackgroundColor(getResources().getColor(R.color.green, null));
                } else {
                    choice1.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                    correctChoice.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                }
                wrongChoiceClicked = !wrongChoiceClicked;
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            boolean wrongChoiceClicked = true;
            @Override
            public void onClick(View v) {
                if (wrongChoiceClicked) {
                    choice2.setBackgroundColor(getResources().getColor(R.color.red, null));
                    correctChoice.setBackgroundColor(getResources().getColor(R.color.green, null));
                } else {
                    choice2.setBackgroundColor(getResources().getColor(R.color.light_yellow, null));
                    correctChoice.setBackgroundColor(getResources().getColor(R.color.light_yellow, null));
                }
                wrongChoiceClicked = !wrongChoiceClicked;
            }
        });

        correctChoice.setOnClickListener(new View.OnClickListener() {
            boolean correctChoiceClicked = true;
            @Override
            public void onClick(View v) {
                if (correctChoiceClicked) {
                    correctChoice.setBackgroundColor(getResources().getColor(R.color.green, null));
                } else {
                    correctChoice.setBackgroundColor(getResources().getColor(R.color.light_yellow, null));
                }
                correctChoiceClicked = !correctChoiceClicked;
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
                } else {
                    ((ImageView) findViewById(R.id.toggle_choices_visibility)).setImageResource(R.drawable.eye_on);
                    choice1.setVisibility(View.VISIBLE);
                    choice2.setVisibility(View.VISIBLE);
                    correctChoice.setVisibility(View.VISIBLE);
                }
                isShowingAnswers = !isShowingAnswers;
            }
        });

        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newCard = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(newCard, 100);
            }
        });

        editCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editCard = new Intent(MainActivity.this, AddCardActivity.class);
                editCard.putExtra("initial_question", flashcardQuestion.getText().toString());
                editCard.putExtra("initial_answer", flashcardAnswer.getText().toString());
                editCard.putExtra("initial_wrong_choice1", choice1.getText().toString());
                editCard.putExtra("initial_wrong_choice2", choice2.getText().toString());
                MainActivity.this.startActivityForResult(editCard, 200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 100 && resultCode == RESULT_OK ) ||
                (requestCode == 200 && resultCode == RESULT_OK)) {
            String question = data.getExtras().getString("new_question");
            String answer = data.getExtras().getString("new_answer");
            String wrong_choice1 = data.getExtras().getString("wrong_choice1");
            String wrong_choice2 = data.getExtras().getString("wrong_choice2");
            TextView flashcardQuestion = findViewById(R.id.flashcard_question_textview);
            TextView flashcardAnswer = findViewById(R.id.flashcard_answer_textview);
            TextView choice1 = findViewById(R.id.choice_1);
            TextView choice2 = findViewById(R.id.choice_2);
            TextView correctChoice = findViewById(R.id.choice_correct);
            flashcardQuestion.setText(question);
            flashcardAnswer.setText(answer);
            choice1.setText(wrong_choice1);
            choice2.setText(wrong_choice2);
            correctChoice.setText(answer);


            Snackbar.make(findViewById(R.id.flashcard_question_textview),
                    "Card successfully created", Snackbar.LENGTH_SHORT).show();
        }
    }
}