package org.baltimorecityschools.piquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView theQuestionTV;
    int currentQuestionIndex;
    Question currentQ;
    int score;
    Button trueButton;
    Button falseButton;
    Button nextButton;
    Question Q1;
    Question Q2;
    Question Q3;
    Question Q4;
    Question Q5;
    Question Q6;
    Question Q7;
    Question Q8;
    Question Q9;
    Question Q10;
    Question[] questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        Q1 = new Question("Pizza is Italian", true);
        Q2 = new Question("Ice cream can come in many flavors", true);
        Q3 = new Question("Cheese is a dairy product", true);
        Q4 = new Question("Dogs can talk", false);
        Q5 = new Question("Roblox was made in 2012", false);
        Q6 = new Question("Mexican food consists of only taco's", false);
        Q7 = new Question("API 24 is called VanillaIceCream", false);
        Q8 = new Question("Birds are the descendants of dinosaurs", true);
        Q9 = new Question("You are on question 9", true);
        Q10 = new Question("There are 5 food groups", true);
        questions = new Question[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10};
        currentQuestionIndex = 0;
        currentQ = Q1;
        theQuestionTV = (TextView) findViewById(R.id.theQuestionTV);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getCorrectAnswer()== true){
                    score++;
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getCorrectAnswer()== false){
                    score++;
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex == 9){
                    Intent leaveIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    leaveIntent.putExtra("score", score);
                    startActivity(leaveIntent);
                }
                else{
                    currentQuestionIndex +=1;
                    currentQ = questions[currentQuestionIndex];
                    theQuestionTV.setText(currentQ.getQText());
                }


            }
        });

    }
}