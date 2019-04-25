package com.example.group2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/*Modified Code from:
Author: Coding in Flow
Year: 2017
Link: https://www.youtube.com/watch?v=5ISNPFmuOU8
*/

public class QuizMain extends AppCompatActivity {
    //Best practice to use the package name as the key-values
    public static final String FINAL_SCORE = "com.example.group2.FINAL_SCORE";
    public static final String FINAL_INCORRECT = "com.example.group2.FINAL_INCORRECT";

    private static final String TAG = "Quiz Main Screen";

    //Initialising the widgets
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewQuestion;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button submitBtn;

    private ColorStateList textColorDefaultRb;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private int score;
    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);
        Log.d(TAG, "Initialising the Quiz Layout");
        //Assigning the widgets to its corresponding XML widget
        textViewScore = findViewById(R.id.scoreText);
        textViewQuestionCount = findViewById(R.id.countText);
        textViewQuestion = findViewById(R.id.questionText);
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        submitBtn = findViewById(R.id.submitBtn);
        textColorDefaultRb = rb1.getTextColors();

        //Intent intent = getIntent();

        DBHelper dbHelper = new DBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        //Getting questions in a random order
        Collections.shuffle(questionList);

        showNextQuestion();

        submitBtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               if (!answered){ //if the question was not answered
                   if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                       checkAnswer(); //if any of the radio buttons are selected, check the answer
                   } else {
                       Toast.makeText(QuizMain.this, "Please Select an Answer", Toast.LENGTH_SHORT).show();
                   }
               } else {
                   showNextQuestion();
               }
           }
        });
    }

    private void showNextQuestion(){
        Log.d(TAG, "Deciding the Next Questions");
        //Setting the radio buttons to a default colour before it will be changed
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        radioGroup.clearCheck(); //to unselect the radio buttons for each new question

        //Testing to verify if there are any more questions left
        if (questionCounter < questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

            //Setting the XML text with our question bank
            textViewQuestion.setText(currentQuestion.getQuestion());

            //Setting the different answers for the options
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            //Setting the values for the current question and the total questions
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false; //locking the question
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer(){
        Log.d(TAG, "Checking Answer");
        answered = true;

        RadioButton radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(radioButtonSelected) + 1;

        //If the answer selected is correct
        if (answerNo == currentQuestion.getAnswerNo()){
            score++; //increase score
            textViewScore.setText("Score: " + score); //display the increased score
        }

        showSolution();
    }

    private void showSolution(){
        Log.d(TAG, "Showing Solution to the User");
        //Set the default colour of the radio button to red
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        //Change the correct answer's radio button to green
        switch(currentQuestion.getAnswerNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is Correct!");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is Correct!");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is Correct!");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 4 is Correct!");
                break;
        }

        if(questionCounter < questionCountTotal){
            submitBtn.setText("Next Question");
        } else {
            //if it is the last question, change the button to signify the quiz has finished
            submitBtn.setText("Finish Quiz");
        }
    }

    //Finish the quiz and sending the scores to the result activity
    private void finishQuiz(){
        int correct = score;
        int incorrect = questionCountTotal - score;
        Intent intent = new Intent(QuizMain.this, ResultMain.class);
        intent.putExtra("Correct", correct);
        intent.putExtra("Incorrect", incorrect);
        startActivity(intent);

        //incorrectAnswers = questionCountTotal - score;
        //Intent resultIntent = new Intent(this, ResultMain.class);
        //resultIntent.putExtra(FINAL_SCORE, score);
        //resultIntent.putExtra(FINAL_INCORRECT, incorrectAnswers);
        //finish();
        //startActivity(resultIntent);
    }
}
