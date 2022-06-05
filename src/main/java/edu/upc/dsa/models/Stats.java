package edu.upc.dsa.models;

public class Stats {
    private int id;
    private String user;
    private String date;
    private int score;

    public Stats(int id, String user, String date, int score) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.score = score;
    }
    public Stats(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
