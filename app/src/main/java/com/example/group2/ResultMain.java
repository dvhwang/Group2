package com.example.group2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ResultMain extends AppCompatActivity {
    public static final String KEY_HIGHSCORE = "com.example.group2.keyHighscore";

    private TextView textViewHighscore;

    private int score;
    private int incorrectScore;
    private int highestScore;
    private int secondHighestScore;
    private int thirdHighestScore;
    private List<Integer> resultList;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_main);

        //Retrieving and assigning the high scores
        dbHelper = new DBHelper(this);
        resultList = dbHelper.getHighScores();
        highestScore = resultList.get(0);
        secondHighestScore = resultList.get(1);
        thirdHighestScore = resultList.get(2);

        //Receives the final score from QuizMain
        Intent intent = getIntent();
        score = intent.getExtras().getInt("FINAL_SCORE");

        //Receive the number of incorrect answers from QuizMain
        incorrectScore = intent.getExtras().getInt("FINAL_INCORRECT");

        //Checking to see if it has beaten the high scores
        if (score > highestScore){
            highestScore = score;
            sendScoretoDB(highestScore);
        }
        else if (score > secondHighestScore){
            thirdHighestScore = secondHighestScore;
            secondHighestScore = score;
            sendScoretoDB(secondHighestScore);
            sendScoretoDB(thirdHighestScore);
        }
        else if (score > thirdHighestScore){
            thirdHighestScore = score;
            sendScoretoDB(thirdHighestScore);
        }
    }

    public void sendScoretoDB(int score){
        dbHelper = new DBHelper(this);
        dbHelper.insertHighScore(score);
    }


}
