package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity implements View.OnClickListener{

    private TextView question, score;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    int currentQuestion;

    public static int current_score;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        option1 = (Button) findViewById(R.id.btn1);
        option2 = (Button) findViewById(R.id.btn2);
        option3 = (Button) findViewById(R.id.btn3);
        option4 = (Button) findViewById(R.id.btn4);

        score = (TextView) findViewById(R.id.your_score);
        question = (TextView) findViewById(R.id.question_view);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        current_score =  0;

        String y = "Score: " + current_score ;

        score.setText(y);
        getQuestionList();

    }

    private void getQuestionList(){
        questionList = new ArrayList<>();
        questionList.add(new Question("question1","A","B", "C","D",2));
        questionList.add(new Question("question2","A","B", "C","D",2));
        questionList.add(new Question("question3","A","B", "C","D",1));
        questionList.add(new Question("question4","A","B", "C","D",4));
        
        setQuestion();
    }

    private void setQuestion() {
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());
        option3.setText(questionList.get(0).getOption3());
        option4.setText(questionList.get(0).getOption4());
        question.setText(questionList.get(0).getQuestion());

        currentQuestion = 0;
    }

    @Override
    public void onClick(View view) {
        int selected = 0;
        switch(view.getId())
        {
            case R.id.btn1:
                selected = 1;
                break;
            case R.id.btn2:
                selected = 2;
                break;
            case R.id.btn3:
                selected = 3;
                break;
            case R.id.btn4:
                selected = 4;
                break;

            default:
        }

        checkAnswer(selected);
    }

    private void checkAnswer(int selected) {

        if(selected == questionList.get(currentQuestion).getAnswerNo()){

            current_score++;
            score.setText("Score: " + current_score);

        }
        else{

        }
        changeQuestion();

    }

    private void changeQuestion() {
        if(currentQuestion < questionList.size() - 1){
            currentQuestion++;
            updateQuestion();

        }
        else{
            Intent intent = new Intent(Quiz.this, FinalScore.class);
            startActivity(intent);
            Quiz.this.finish();
        }
    }

    private void updateQuestion() {
        question.setText(questionList.get(currentQuestion).getQuestion());
        option1.setText(questionList.get(currentQuestion).getOption1());
        option2.setText(questionList.get(currentQuestion).getOption2());
        option3.setText(questionList.get(currentQuestion).getOption3());
        option4.setText(questionList.get(currentQuestion).getOption4());

    }

    public static int get_score(){
        return current_score;
    }
}