package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Category extends AppCompatActivity {

    private Button java;
    private Button python;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        java = findViewById(R.id.category1);
        python = findViewById(R.id.category2);

        java.setOnClickListener(view -> {
            Intent intent = new Intent(Category.this, Quiz.class);
            startActivity(intent);
        });

       python.setOnClickListener(view -> {
            Intent intent = new Intent(Category.this, Quiz.class);
            startActivity(intent);
        });
    }
}