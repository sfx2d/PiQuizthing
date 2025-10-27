package org.baltimorecityschools.piquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
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
        // Keep links inside the WebView instead of opening the browser
        WebView myWebView = (WebView) findViewById(R.id.webview);
        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        Q1 = new Question("Pizza is Italian", true, "https://en.wikipedia.org/wiki/History_of_pizza");
        Q2 = new Question("Ice cream can come in many flavors", true, "https://en.wikipedia.org/wiki/Ice_cream");
        Q3 = new Question("Cheese is a dairy product", true, "https://en.wikipedia.org/wiki/Dairy_product");
        Q4 = new Question("Dogs can talk", false, "https://www.youtube.com/watch?v=01le4Ln8da0");
        Q5 = new Question("Roblox was made in 2012", false, "https://en.wikipedia.org/wiki/Roblox");
        Q6 = new Question("Mexican food consists of only tacos", false, "https://en.wikipedia.org/wiki/Mexican_cuisine");
        Q7 = new Question("API 24 is called VanillaIceCream", false, "https://en.wikipedia.org/wiki/Android_version_history");
        Q8 = new Question("Birds are the descendants of dinosaurs", true, "https://www.scientificamerican.com/article/how-dinosaurs-shrank-and-became-birds/");
        Q9 = new Question("Chicken originates in Italy", false, "https://livestock.extension.wisc.edu/articles/origin-and-history-of-the-chicken/");
        Q10 = new Question("There mushrooms that are edible", true, "https://www.youtube.com/watch?v=HtEAZQAOS4w");
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
                    // Load the initial URL
                    myWebView.loadUrl(currentQ.getLinkText());
                    myWebView.setVisibility(View.VISIBLE);
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
                    // Load the initial URL
                    myWebView.loadUrl(currentQ.getLinkText());
                    myWebView.setVisibility(View.VISIBLE);
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
                    myWebView.setVisibility(View.GONE);
                }


            }
        });


    }
}