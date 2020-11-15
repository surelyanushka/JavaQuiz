package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play = findViewById(R.id.lets_play_btn);

       Play.setOnClickListener(view -> {
           Intent intent = new Intent(MainActivity.this,Category.class);
           startActivity(intent);
       });
    }
}