package org.baltimorecityschools.piquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
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
    Button sendScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        sendScoreButton = (Button) findViewById(R.id.sendScoreButton);
        Intent intent = getIntent();
        saysSCORE = (TextView) findViewById(R.id.saysSCORE);
        scoreNumber = (TextView) findViewById(R.id.scoreNumber);
        score = intent.getIntExtra("score", score);
        scoreNumber.setText(String.valueOf(score));
        sendScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String body = "New score on Food Quiz ";
                String subject = "Your score is " + score;
                composeEmail(body, subject);
            }
        });





    }
    // composeEmail method copied from Android developers


    public void composeEmail(String body, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_TEXT, subject);
        intent.putExtra(Intent.EXTRA_SUBJECT, body);
        startActivity(intent);
    }



}