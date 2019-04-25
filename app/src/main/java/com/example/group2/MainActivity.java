package com.example.group2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ImageButton quiz;
    ImageButton consulting;
    ImageButton careers;
    ImageButton framework;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz = findViewById(R.id.quizIV);
        consulting = findViewById(R.id.consultingIV);
        careers = findViewById(R.id.careersIV);
        framework = findViewById(R.id.frameworkIV);

        //onClick for consultingIV
        careers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: learn imageView clicked");
                Intent intent = new Intent(MainActivity.this, CareersMain.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Consulting intent launched");
            }
        });

        quiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG, "onClick: Quiz Start button clicked");
                Intent intent = new Intent(MainActivity.this, QuizMain.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Quiz intent launched");
            }

        });



        }
    }




