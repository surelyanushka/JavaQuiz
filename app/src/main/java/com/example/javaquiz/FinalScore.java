package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScore extends AppCompatActivity {

//This is the final activity
    private Button play_again;

    int final_score = Quiz.get_score();
    private TextView score_display;
    private String result;

    public void onBackPressed(){
        Intent intent = new Intent(FinalScore.this, Category.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        score_display = (TextView) findViewById(R.id.display_score);
        result = final_score + "/5";
        score_display.setText(result);


        play_again = findViewById(R.id.play_again_btn);
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalScore.this, Category.class);
                startActivity(intent);
                finish();

            }
        });
    }
}