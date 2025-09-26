package org.baltimorecityschools.piquiz;

import androidx.annotation.NonNull;

public class Question {
    private String qText;
    private boolean correctAnswer;

    public Question(){
        qText = "";
        correctAnswer = true;
    }
    public Question(String qTextE, boolean correctAnswerE){
        qText = qTextE;
        correctAnswer = correctAnswerE;
    }
    // getters
    public String getQText() {return qText;}
    public boolean getCorrectAnswer(){return correctAnswer;}
    //setters
    public void setQText(String newQText){qText = newQText;}
    public void setCorrectAnswer(boolean newCorrectAnswer){correctAnswer = newCorrectAnswer;}

    @NonNull
    @Override
    public String toString() {
        return "Question: " + qText + " " + correctAnswer;
    }
}
