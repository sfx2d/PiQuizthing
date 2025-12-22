package org.baltimorecityschools.piquiz;

public class HighScoreEntry {
    private String userName;
    private int pointScore;


    public  HighScoreEntry(){
        userName = "";
        pointScore = 0;

    }

    public HighScoreEntry(String userName, int pointScore) {
        this.userName = userName;
        this.pointScore = pointScore;

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


    public String toString() {
        return userName + " " + pointScore;}
}
