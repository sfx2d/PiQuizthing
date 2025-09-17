package org.baltimorecityschools.piquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView saysSCORE;
    TextView scoreNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        saysSCORE = (TextView) findViewById(R.id.saysSCORE);
        scoreNumber = (TextView) findViewById(R.id.scoreNumber);
        score = intent.getIntExtra("score", score);
        scoreNumber.setText(String.valueOf(score));

    }

}