package com.example.group2;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

//Creating the QuestionRoomDatabase
@Database(entities = {Question.class}, version = 1)
public abstract class QuestionRoomDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();

    private static volatile QuestionRoomDatabase INSTANCE;

    //Preventing multiple instances of the database to open at the same time
    static QuestionRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (QuestionRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), QuestionRoomDatabase.class, "question_database")
                            .addCallback(aRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback aRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDBAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDBAsync extends AsyncTask<Void, Void, Void> {
        private final QuestionDao mDao;

        PopulateDBAsync(QuestionRoomDatabase db){
            mDao = db.questionDao();
        }

        @Override
        protected Void doInBackground(final Void... params){
            mDao.deleteAll();
            Question q1= new Question(12222, "What is Porter's Five Model",
                    "XYZ", "zyxxx", "zysss", "zyxxx");
            mDao.insert(q1);
            return null;
        }
    }
}
