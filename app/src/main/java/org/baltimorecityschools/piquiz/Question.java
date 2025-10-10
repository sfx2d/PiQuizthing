package org.baltimorecityschools.piquiz;

import androidx.annotation.NonNull;

public class Question {
    private String qText;
    private boolean correctAnswer;
    private String linkText;

    public Question(){
        qText = "";
        correctAnswer = true;
        linkText = "";

    }
    public Question(String qTextE, boolean correctAnswerE, String linkTexth){
        qText = qTextE;
        correctAnswer = correctAnswerE;
        linkText = linkTexth;
    }
    // getters
    public String getQText() {return qText;}
    public boolean getCorrectAnswer(){return correctAnswer;}
    public String getLinkText(){return linkText;}
    //setters
    public void setQText(String newQText){qText = newQText;}
    public void setCorrectAnswer(boolean newCorrectAnswer){correctAnswer = newCorrectAnswer;}
    public void setLinkText(String newLinkText){linkText = newLinkText;}

    @NonNull
    @Override
    public String toString() {
        return "Question: " + qText + " " + correctAnswer + linkText;
    }
}
