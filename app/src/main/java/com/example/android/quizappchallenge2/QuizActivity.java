package com.example.android.quizappchallenge2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements RadioButton.OnCheckedChangeListener {
    private TextView tvQuestionTitle;
    private TextView tvQuestion;
    private TextView tvAnswer;
    private TextView tvShowAnswers;
    private RadioButton ansA;
    private RadioButton ansB;
    private RadioButton ansC;
    private RadioButton ansD;
    private RadioButton choice;
    private Button btnSubmit;
    private int question_number=0;
    private String correctAns;
    private RadioGroup ansBox;
    private String ansHistory = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setTitle("Android Quiz");
        tvQuestion = (TextView) findViewById(R.id.question);
        tvQuestionTitle = (TextView) findViewById(R.id.question_title);
        ansA = (RadioButton) findViewById(R.id.ansA);
        ansB = (RadioButton) findViewById(R.id.ansB);
        ansC = (RadioButton) findViewById(R.id.ansC);
        ansD = (RadioButton) findViewById(R.id.ansD);
        ansA.setOnCheckedChangeListener(this);
        ansB.setOnCheckedChangeListener(this);
        ansC.setOnCheckedChangeListener(this);
        ansD.setOnCheckedChangeListener(this);
        tvAnswer = findViewById(R.id.correctAns);
        tvShowAnswers = findViewById(R.id.tvShowAnswers);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markAndMoveToNextQstn();
            }
        });
        nextQuestion();
    }

    private void markAndMoveToNextQstn() {
        if(choice != null){
            if(question_number >4){
                return;
            }
            String tag = choice.getTag().toString();
            if(tag.equals("right")){
                ansHistory = ansHistory + "\nQuestion "+(question_number + 1) + ": Correct("+correctAns+")";
            }else{
                ansHistory = ansHistory + "\nQuestion "+(question_number + 1) + ": "+"Wrong!The answer is: "+correctAns;
            }
            question_number++;
            nextQuestion();

        }else{
            Toast.makeText(this,"Select an answer!",Toast.LENGTH_SHORT).show();
        }
    }

    private void nextQuestion(){
        if(question_number > 4){
            Toast.makeText(this,"Quiz is over!",Toast.LENGTH_SHORT).show();
            tvShowAnswers.setText(ansHistory);
            tvShowAnswers.setVisibility(View.VISIBLE);
            return;
        }
        switch (question_number){
            case 0:
                dispQstnOne();
                break;
            case 1:
                dispQstnTwo();
                break;
            case 2:
                dispQstnThree();
                break;
            case 3:
                dispQstnFour();
                break;
            case 4:
                dispQstnFive();
                break;
        }
    }

    private void dispQstnFive() {
        tvQuestionTitle.setText("Question 5: ");
        tvQuestion.setText("Through which platform are Android Apps published to the market?");

        ansA.setTag("wrong");
        ansA.setText("GitHub");

        ansB.setTag("wrong");
        ansB.setText("Microsoft Store");

        ansC.setTag("wrong");
        ansC.setText("YouTube");

        ansD.setTag("right");
        ansD.setText("Google Play Store");

        question_number = 4;
        correctAns = "Google Play Store";
    }

    private void dispQstnFour() {
        tvQuestionTitle.setText("Question 4: ");
        tvQuestion.setText("Which is the newest language in Android App Development?");

        ansA.setTag("wrong");
        ansA.setText("JQuery");

        ansB.setTag("wrong");
        ansB.setText("Elixir");

        ansC.setTag("right");
        ansC.setText("Kotlin");

        ansD.setTag("wrong");
        ansD.setText("Java");

        question_number = 3;
        correctAns = "Kotlin";
    }

    private void dispQstnThree() {
        tvQuestionTitle.setText("Question 3: ");
        tvQuestion.setText("Which one of the following is not a layout element in Android UI development?");

        ansA.setTag("wrong");
        ansA.setText("LinerLayout");

        ansB.setTag("wrong");
        ansB.setText("CardView");

        ansC.setTag("wrong");
        ansC.setText("RelativeLayout");

        ansD.setTag("right");
        ansD.setText("Blockquote");

        question_number = 2;
        correctAns = "Blockquote";
    }

    private void dispQstnTwo() {
        tvQuestionTitle.setText("Question 2: ");
        tvQuestion.setText("Which is the latest Android version in the market?");

        ansA.setTag("wrong");
        ansA.setText("Nougat - 7");

        ansB.setTag("wrong");
        ansB.setText("Gingerbread - 2");

        ansC.setTag("right");
        ansC.setText("Oreo - 8");

        ansD.setTag("wrong");
        ansD.setText("Lollipop - 5");

        question_number = 1;
        correctAns = "Oreo - 8";
    }

    private void dispQstnOne(){
        tvQuestionTitle.setText("Question 1: ");
        tvQuestion.setText("Which one of the following IDEs is used in Android Application Development?");

        ansA.setTag("wrong");
        ansA.setText("PhpStorm");

        ansB.setTag("wrong");
        ansB.setText("Sublime Text");

        ansC.setTag("wrong");
        ansC.setText("Notepad++");

        ansD.setTag("right");
        ansD.setText("Android Studio");

        question_number = 0;
        correctAns = "Android Studio";
        tvAnswer.setText("");
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String ans = "";
        choice = null;
        switch (buttonView.getId()){
            case R.id.ansA:
                ans = "A";
                choice = ansA;
                break;
            case R.id.ansB:
                ans = "A";
                choice = ansB;
                break;
            case R.id.ansC:
                ans = "A";
                choice = ansC;
                break;
            case R.id.ansD:
                ans = "D";
                choice = ansD;
                break;
        }
    }
}
