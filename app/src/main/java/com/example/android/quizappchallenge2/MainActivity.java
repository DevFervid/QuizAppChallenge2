package com.example.android.quizappchallenge2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnTakeQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind the btnTakeQuiz to the button in the view.
        btnTakeQuiz = (Button) findViewById(R.id.btnTakeQuiz);
        //Listen to button click.
        btnTakeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });
    }

    private void openQuiz(){
        //Will open the quiz activity.
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }
}
