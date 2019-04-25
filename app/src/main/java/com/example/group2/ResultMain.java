package com.example.group2;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
/* Setting Up Pie Chart, Modified Code from:
Author: CodingWithMitch
Year: 2016
Link: https://www.youtube.com/watch?v=8BcTXbwDGbg
 */

public class ResultMain extends AppCompatActivity {
    public static final String KEY_HIGHSCORE = "com.example.group2.keyHighscore";

    private TextView textViewHighscore;

    private int score;
    float[] pieScore;
    private String status[] = {"Correct", "Incorrect"};
    private float incorrectScore;
   /* private float highestScore;
    private float secondHighestScore;
    private float thirdHighestScore;
    private List<Integer> resultList;
*/
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_main);


        //Receives the final score from QuizMain
        Intent intent = getIntent();
        score = intent.getExtras().getInt("Correct");

        //Receive the number of incorrect answers from QuizMain
        incorrectScore = intent.getExtras().getInt("Incorrect");

        sendScoretoDB(score);

       /* //Checking to see if it has beaten any of the top 3 scores
        if (score >= highestScore){
            highestScore = score;
            sendScoretoDB(highestScore);
        }
        else if (score >= secondHighestScore){
            thirdHighestScore = secondHighestScore; //the previous second highest score is now the third highest score
            secondHighestScore = score;
            sendScoretoDB(secondHighestScore);
            sendScoretoDB(thirdHighestScore);
        }
        else if (score >= thirdHighestScore){
            thirdHighestScore = score;
            sendScoretoDB(thirdHighestScore);
        }*/

        //Retrieving and assigning the high scores
        dbHelper = new DBHelper(this);
        //resultList = dbHelper.getHighScores();
/*        highestScore = resultList.get(0);
        secondHighestScore = resultList.get(1);
        thirdHighestScore = resultList.get(2);*/

        //Changing Score to Float for Pie Chart
        pieScore = new float[2];
        float correctNo = (float) score;
        float incorrectNo = incorrectScore;
        pieScore[0] = correctNo;
        pieScore[1] = incorrectNo;
        setUpPieChart();

    }

    public void sendScoretoDB(int score){
        dbHelper = new DBHelper(this);
        dbHelper.insertHighScore(score);
    }

    private void setUpPieChart(){
        List<PieEntry> pieEntry = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            pieEntry.add(new PieEntry(pieScore[i],status[i]));
        }

        //Adding the data into the Pie Chart and changing the colours of the chart
        PieDataSet dataSet = new PieDataSet(pieEntry, "Quiz Results");
        dataSet.setValueTextSize(40f);
        int[] pieColours = {Color.rgb(135, 232, 17), Color.rgb(232, 57, 18)};
        dataSet.setColors(ColorTemplate.createColors(pieColours));

        PieData data = new PieData(dataSet);

        //Creating the Visual elements of the Pie Chart
        PieChart chart = findViewById(R.id.pieChart);
        dataSet.setLabel("");
        chart.setData(data);
        chart.animateY(1000);
        chart.setEntryLabelTextSize(15f);
        chart.setCenterTextSizePixels(20f);
        chart.setHoleRadius(30f);
        chart.setTransparentCircleRadius(35f);

        //Resets the Pie Chart
        chart.invalidate();
    }


}
