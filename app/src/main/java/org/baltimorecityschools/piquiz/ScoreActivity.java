package org.baltimorecityschools.piquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {
    private ArrayList<HighScoreEntry> highScores;
    HighScoreEntry myHSE;
    int score;
    TextView scoreNumber, score1, userName1;
    EditText userNameET;
    Button sendScoreButton, submitName;
    FirebaseDatabase database;
    DatabaseReference myRef;
    SharedPreferences HighScoreRetain;
    LinearLayout layoutTitles, layout1;
    final String sharedPreferencesFile = "org.baltimorecityschools.piquiz.sp";
    final String HIGH_SCORENAME_KEY = "HIGHSCORENAME";
    final String TAG = "ABCDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        highScores = new ArrayList<HighScoreEntry>();
        score1 = findViewById(R.id.score1);
        userName1 = findViewById(R.id.userName1);

        sendScoreButton = findViewById(R.id.sendScoreButton);
        submitName = findViewById(R.id.submitName);
        Intent intent = getIntent();
        userNameET = findViewById(R.id.userNameET);
        scoreNumber = findViewById(R.id.scoreNumber);
        score = intent.getIntExtra("score", score);
        scoreNumber.setText(String.valueOf(score));
        HighScoreRetain = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);
        SharedPreferences.Editor spEditor = HighScoreRetain.edit();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        layoutTitles = findViewById(R.id.layoutTitles);
        layout1 = findViewById(R.id.layout1);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot highScoreSnapShot : dataSnapshot.getChildren()) {
                    //From our snapshot, get the value of our key/value pair. This value
                    //contains a customer object
                    String name = highScoreSnapShot.child("userName").getValue(String.class);
                    int score = highScoreSnapShot.child("pointScore").getValue(Integer.class);
                    myHSE = new HighScoreEntry(name, score);


                    Log.d("onDataChange()", myHSE.toString());
                    highScores.add(myHSE);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });







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
                HighScoreEntry nameEntry = new HighScoreEntry(userName, score);
                String key = myRef.push().getKey();
                myRef.child(key).setValue(nameEntry);
                layoutTitles.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.VISIBLE);
                if(highScores.size()> 0){
                    HighScoreEntry getHighScore = highScores.get(0);
                    String name = getHighScore.getUserName();
                    int score = getHighScore.getPointScore();
                    userName1.setText(name);
                    score1.setText(score + "");
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