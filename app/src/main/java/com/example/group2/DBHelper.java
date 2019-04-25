package com.example.group2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.group2.QuizContainer.*;
import com.example.group2.ResultContainer.*;

import java.util.ArrayList;
import java.util.List;

/*Modified Code from:
Author: Coding in Flow
Year: 2017
Link: https://www.youtube.com/watch?v=5ISNPFmuOU8
*/

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Question.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "DBHelper";

    //Reference to the database itself
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Called when DB is first created
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        Log.d(TAG, "onCreate: Creating Database");

        //SQL query to create the Question table
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NO + " INTEGER" +
                ")";

        //SQL query to create the Result table
        final String SQL_CREATE_RESULT_TABLE = "CREATE TABLE " +
                ResultTable.TABLE_NAME + " ( " +
                ResultTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ResultTable.COLUMN_RESULT + " INTEGER " + ")";

        //To execute the SQL queries above
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        db.execSQL(SQL_CREATE_RESULT_TABLE);

        //Invoke method which will have all the question
        makeQuestions();
    }

    //Updates the table, if there are changes made to the existing table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ResultTable.TABLE_NAME);
        onCreate(db);
    }


    private void makeQuestions(){
        Question q1 = new Question("What does MECE Stand For?", "Mutually Exhaustive, Collectively Exclusive", "Mutually Exclusive Collectively Entire", "Mutually Exclusive, Collectively Exhaustive", "Mutually Encyclopedic, Collectively Exhaustive", 3);
        insertQuestion(q1);

        Question q2 = new Question("What are the two main categories within a profitability tree?", "Products and Wages", "Revenue and Costs", "Income and COGS", "Pricing and Distribution", 2);
        insertQuestion(q2);

        Question q3 = new Question("In a profitability tree, how many types of costs are there typically?", "2", "4", "3", "6", 1);
        insertQuestion(q3);

        Question q4= new Question("What is the typical use of Porter's Five Forces?", "Understanding how easy it is for suppliers to drive up prices", "Working out the intensity of competition in the market", "Looking at the performance of substitutes and competitors", "Assessing new markets and industries", 4);
        insertQuestion(q4);

        Question q5= new Question("What are the 4P's in the 4P's Marketing Mix Framework?", "Placards, Postal, Package, Pace", "Product, Price, Place, Promotion", "Pairs, Pack, Products, Place", "Package, Place, Postal, Pairs", 2);
        insertQuestion(q5);

        Question q6= new Question("What is an example of \"ME\" in MECE?", "Teenage Audience, Male Audience", "Online Customers, Male Customers", "Male Customers, Female Customers", "Online Customers, In-Store Customers", 3);
        insertQuestion(q6);

        Question q7 = new Question("What is an example of \"CE\" in MECE?", "Online Customers, In-Store Customers", "Teenage Customers, Female Customers", "In-Store Customers, Male Customers", "Retail Customers, Partner-Store Customers", 1);
        insertQuestion(q7);

        Question q8 = new Question("If given the question \"Who should Uber target when entering a new market?\", what would be an appropriate approach to the question?", "MECE", "Porter's Five Forces", "SWOT Analysis", "Demographic Tree", 4);
        insertQuestion(q8);

        Question q9 = new Question("Which of the following is an example of Porter's Five Forces?", "Competition", "Threat of Suppliers", "New Markets", "Marketing Power", 1);
        insertQuestion(q9);

        Question q10 = new Question("Why is MECE important?", "It helps you understand markets easily", "It makes looking at different customer segments easier", "It is a structured method of organising and breaking down problems", "Because Rick and Morty would be proud", 3);
        insertQuestion(q10);

        Question q11 = new Question("If you are asked to break down the question \"How does Company Y increase their profitability\"? with a profitability tree, what would be the two most appropriate categories?", "Increase in Revenue, Increase in Costs", "Decrease in Revenue, Decrease in Costs", "Decrease in Revenue, Increase in Costs", "Increase in Revenue, Decrease in Costs", 4);
        insertQuestion(q11);

        Question q12 = new Question("In a profitability tree, what are the two main types of cost?", "Varying Costs, Variable Costs", "Fixed Costs, Variable Costs", "Static Costs, Statistical Costs", "Costs, Costs per Customer", 2);
        insertQuestion(q12);

        Question q13 = new Question("In a typical profitability tree, what are the two main drivers of revenue?", "Pricing per unit, amount of customers", "Amount of Customers, Distribution of Customers", "Customer Segments sold to, Distribution Channel", "Pricing per unit, Volume of units sold", 4);
        insertQuestion(q13);

        Question q14 = new Question("When applying Porter's Five Forces, what would be some questions you might ask for Supplier Power?", "How easy is it for suppliers to drive up prices, and what is the size of each supplier?", "What is the perceived level of product differentiation?", "How many customers are there?", "What are the barriers to enter the market?", 1);
        insertQuestion(q14);

        Question q15 = new Question("When applying Porter's Five Forces, what would be some questions you might ask for New Entrants?", "How easy is it for buyers to drive prices down?", "Do your customers find substitutes easily? ", "Is it easy or difficult to enter the market, and what are the barriers of entry to the market?", "How easy is it for suppliers to drive up prices?", 3);
        insertQuestion(q15);

        Question q16 = new Question("When applying the 4P's Marketing Mix, what would be a key consideration for Product?", "Understanding the price of the product, and the amount paid by the customer", "Considering the functionality, appearance or quality of the product", "Geographical availability of the product to consumers", "Transportation of the product to consumers", 2);
        insertQuestion(q16);

        Question q17 = new Question("When applying the 4P's Marketing Mix, what would be a key consideration for Price?", "Looking at the appearance of products for consumers", "Focusing promotional materials on targeted customer segments", "Considering the amount of money paid by customers to purchase the product", "Looking at the brand and packaging of the products", 3);
        insertQuestion(q17);
    }

    //Adds the questions into database
    private void insertQuestion(Question question){
        ContentValues content = new ContentValues();
        Log.d(TAG, "Inserting the questions");

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
        Log.d(TAG, "Retrieving the questions");

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
       // cursor.close();
        return questionList;
    }

    public void insertHighScore(int score){
        db = getReadableDatabase();
        ContentValues content = new ContentValues();
        Log.d(TAG, "Inserting High Scores");
        content.put(ResultTable.COLUMN_RESULT, score);
        db.insert(ResultTable.TABLE_NAME, null, content);
    }

   public List<Integer> getHighScores(){
        List<Integer> scoreList = new ArrayList<>();
        Log.d(TAG, "Retrieving High Scores");

        db = getReadableDatabase();

        //To return the top 3 results from the Result Table in descending order
        Cursor cursor = db.rawQuery("SELECT * FROM " + ResultTable.TABLE_NAME, null);

        if (cursor.moveToFirst()){
            do {
                scoreList.add(cursor.getInt(cursor.getColumnIndex(ResultTable.COLUMN_RESULT)));
            } while(cursor.moveToNext());
        }
        //cursor.close();
        return scoreList;
    }
}
