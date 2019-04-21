package com.example.group2;


import android.support.annotation.NonNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


//Creating a Questions table
@Entity
public class Question {

    //Introducing the table columns
    @NonNull
    @PrimaryKey
    private int qId;

    @NonNull
    private String question;

    @NonNull
    private String correctAnswer;

    @NonNull
    private String incorrectAnswer1;

    @NonNull
    private String incorrectAnswer2;

    @NonNull
    private String incorrectAnswer3;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getIncorrectAnswer1() {
        return incorrectAnswer1;
    }

    public void setIncorrectAnswer1(String incorrectAnswer1) {
        this.incorrectAnswer1 = incorrectAnswer1;
    }

    public String getIncorrectAnswer2() {
        return incorrectAnswer2;
    }

    public void setIncorrectAnswer2(String incorrectAnswer2) {
        this.incorrectAnswer2 = incorrectAnswer2;
    }

    public String getIncorrectAnswer3() {
        return incorrectAnswer3;
    }

    public void setIncorrectAnswer3(String incorrectAnswer3) {
        this.incorrectAnswer3 = incorrectAnswer3;
    }
}
