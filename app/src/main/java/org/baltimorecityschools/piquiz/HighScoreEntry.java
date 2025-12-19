package org.baltimorecityschools.piquiz;

public class HighScoreEntry {
    private String userName;
    private int pointScore;
    private int questionsCorrect;

    public  HighScoreEntry(){
        userName = "";
        pointScore = 0;
        questionsCorrect = 0;
    }

    public HighScoreEntry(String userName, int pointScore, int questionsCorrect) {
        this.userName = userName;
        this.pointScore = pointScore;
        this.questionsCorrect = questionsCorrect;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPointScore() {
        return pointScore;
    }

    public void setPointScore(int pointScore) {
        this.pointScore = pointScore;
    }

    public int getQuestionsCorrect() {
        return questionsCorrect;
    }

    public void setQuestionsCorrect(int questionsCorrect) {
        this.questionsCorrect = questionsCorrect;
    }
    public String toString() {
        return userName + " " + pointScore + " " + questionsCorrect;}
}
