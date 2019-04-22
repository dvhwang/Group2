package com.example.group2;


import android.support.annotation.NonNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


//Creating a Questions table
@Entity
public class Question {

    //Creating a Questions constructor
    public Question(int qId, String question, String correctAnswer, String incorrect1, String incorrect2, String incorrect3){
        this.qId = qId;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrect1 = incorrect1;
        this.incorrect2 = incorrect2;
        this.incorrect3 = incorrect3;
    }

    //Introducing the table columns
    @NonNull
    @PrimaryKey
    private int qId;

    @NonNull
    private String question;

    @NonNull
    private String correctAnswer;

    @NonNull
    private String incorrect1;

    @NonNull
    private String incorrect2;

    @NonNull
    private String incorrect3;

    //Getter and Setter methods for the columns
    @NonNull
    public String getIncorrect1() {
        return incorrect1;
    }

    public void setIncorrect1(@NonNull String incorrect1) {
        this.incorrect1 = incorrect1;
    }

    @NonNull
    public String getIncorrect2() {
        return incorrect2;
    }

    public void setIncorrect2(@NonNull String incorrect2) {
        this.incorrect2 = incorrect2;
    }

    @NonNull
    public String getIncorrect3() {
        return incorrect3;
    }

    public void setIncorrect3(@NonNull String incorrect3) {
        this.incorrect3 = incorrect3;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull String question) {
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

    public void setCorrectAnswer(@NonNull String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
