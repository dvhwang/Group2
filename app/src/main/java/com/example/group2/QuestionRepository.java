package com.example.group2;

import android.app.Application;
import android.os.AsyncTask;
import java.util.List;

public class QuestionRepository {
    private QuestionDao mQuestionDao;
    private List<Question> allQuestions;

    QuestionRepository(Application application){
        QuestionRoomDatabase db = QuestionRoomDatabase.getDatabase(application);
        mQuestionDao = db.questionDao();
        allQuestions = mQuestionDao.getAllQuestions();
    }

    List<Question> getAllQuestions(){
        return allQuestions;
    }

    public void insert(Question question){
        new insertAsyncTask(mQuestionDao).execute(question);
    }

    private static class insertAsyncTask extends AsyncTask<Question, Void, Void> {
        private QuestionDao mAsyncTaskDao;

        insertAsyncTask(QuestionDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Question... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
