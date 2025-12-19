package org.baltimorecityschools.piquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView userName;
    TextView scoreNumber;
    EditText userNameET;
    Button sendScoreButton, submitName;
    SharedPreferences HighScoreRetain;
    final String sharedPreferencesFile = "org.baltimorecityschools.piquiz.sp";
    final String HIGH_SCORENAME_KEY = "HIGHSCORENAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        sendScoreButton = findViewById(R.id.sendScoreButton);
        submitName = findViewById(R.id.submitName);
        Intent intent = getIntent();
        userNameET = findViewById(R.id.userNameET);
        scoreNumber = findViewById(R.id.scoreNumber);
        score = intent.getIntExtra("score", score);
        scoreNumber.setText(String.valueOf(score));
        HighScoreRetain = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);

        SharedPreferences.Editor spEditor = HighScoreRetain.edit();







        //Buttons
        sendScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String body = "New score on Food Quiz ";
                String subject = "Your score is " + score;
                composeEmail(body, subject);
            }
        });
        submitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameET.getText().toString();
                if (!userName.equals("")){
                    spEditor.putString(HIGH_SCORENAME_KEY, userName);
                    spEditor.apply();
                    Log.d(HIGH_SCORENAME_KEY, userName);
                }

            }
        });





    }
    // composeEmail method copied from Android developers


    public void composeEmail(String body, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(intent);
    }



}