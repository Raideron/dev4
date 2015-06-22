package com.quiz.dev4.quiz;

/**
 * Created by Alex on 22-6-2015.
 */
public class Question {
    private String question;
    private String genre;

    public Question() {

    }

    public Question(String question, String genre) {
        this.question = question;
        this.genre = genre;
    }

    public String getQuestion() {
        return question;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
