package com.example.bensflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ImageView cancelButton = findViewById(R.id.cancel_button);
        ImageView saveButton = findViewById(R.id.save_button);
        EditText question = findViewById(R.id.add_question);
        EditText answer = findViewById(R.id.add_answer);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("question", question.getText().toString());
                data.putExtra("answer", answer.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }
}