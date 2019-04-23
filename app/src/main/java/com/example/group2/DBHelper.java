package com.example.group2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.group2.QuizContainer.*;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Question.db";
    private static final int DATABASE_VERSION = 1;

    //Reference to the database itself
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Called when DB is first created
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        //SQL query to create the table
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NO + "INTEGER " +
                ")";

        //To execute the SQL query above
        db.execSQL(SQL_CREATE_QUESTION_TABLE);

        //Invoke method which will have all the question
        makeQuestions();
    }

    //Updates the table, if there are changes made to the existing table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }


    private void makeQuestions(){
        Question q1 = new Question();
        insertQuestion(q1);
    }

    //Adds the questions into database
    private void insertQuestion(Question question){
        ContentValues content = new ContentValues();

        //To set which values belongs to which column
        content.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        content.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        content.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        content.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        content.put(QuestionTable.COLUMN_OPTION4, question.getOption4());
        content.put(QuestionTable.COLUMN_ANSWER_NO, question.getAnswerNo());

        //Insert the corresponding values into the table
        db.insert(QuestionTable.TABLE_NAME, null, content);
    }

    //To retrieve the all the questions
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();

        //Open the database for reading
        db = getReadableDatabase();

        //Querying the database to return all the values inside our Question table
        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        //Perform action if there is an entry on the first line
        if (cursor.moveToFirst()){
            do {
                //Setting the values
                Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNo(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ANSWER_NO)));

                //Adding these values to the Question list
                questionList.add(question);
            } while(cursor.moveToNext()); //move to the next entry if there is an entry that exists on the first line
        }
        cursor.close();
        return questionList;
    }
}
