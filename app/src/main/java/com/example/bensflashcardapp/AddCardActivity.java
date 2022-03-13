package com.example.bensflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ImageView cancelButton = findViewById(R.id.cancel_button);
        ImageView saveButton = findViewById(R.id.save_button);
        String initialQuestion = getIntent().getStringExtra("initial_question");
        String initialAnswer = getIntent().getStringExtra("initial_answer");
        String initialWrongChoice1 = getIntent().getStringExtra("initial_wrong_choice1");
        String initialWrongChoice2 = getIntent().getStringExtra("initial_wrong_choice2");
        EditText question = findViewById(R.id.add_question);
        EditText answer = findViewById(R.id.add_answer);
        EditText wrongChoice1 = findViewById(R.id.add_choice1);
        EditText wrongChoice2 = findViewById(R.id.add_choice2);
        question.setText(initialQuestion);
        answer.setText(initialAnswer);
        wrongChoice1.setText(initialWrongChoice1);
        wrongChoice2.setText(initialWrongChoice2);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_question = question.getText().toString();
                String new_answer = answer.getText().toString();
                String wrong_choice1 = wrongChoice1.getText().toString();
                String wrong_choice2 = wrongChoice2.getText().toString();
                Boolean empty = Boolean.TRUE;
                while (empty == Boolean.TRUE) {
                    if (new_question.isEmpty() || new_answer.isEmpty()
                            || wrong_choice1.isEmpty() || wrong_choice2.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Must enter values for all " +
                                "empty fields", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        empty = Boolean.FALSE;
                    }
                }
                Intent data = new Intent();
                data.putExtra("new_question", new_question);
                data.putExtra("new_answer", new_answer);
                data.putExtra("wrong_choice1", wrong_choice1);
                data.putExtra("wrong_choice2", wrong_choice2);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}