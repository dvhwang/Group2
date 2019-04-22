package com.example.group2;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;

@Dao
public interface QuestionDao {

    //Adding a question
    @Insert
    void insert(Question question);


    //Get all questions
    @Query("SELECT * FROM Question")
    List<Question> getAllQuestions();

    //Delete all questions
    @Query("DELETE FROM Question")
    void deleteAll();

}
