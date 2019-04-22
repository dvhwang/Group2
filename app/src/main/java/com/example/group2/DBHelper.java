package com.example.group2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.group2.QuizContainer.*;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Question.db";
    private static final int DATABASE_VERSION = 1;

    //Reference to the database itself
    private SQLiteDatabase db;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
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

        //Metho to insert the questions inside the table
        insertQuestions();
    }

    //Updates the table, if there are changes made to the existing table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    //Method to insert the questions
    private void insertQuestions(){
        Question q1 = new Question()
    }
}
