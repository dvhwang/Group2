package com.example.group2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository mRepository;
    private List<Question> mAllQuestions;

    public QuestionViewModel(Application application){
        super(application);
        mRepository = new QuestionRepository(application);
        mAllQuestions = mRepository.getAllQuestions();
    }

    List<Question> getmAllQuestions(){
        return mAllQuestions;
    }

    public void insert(Question question){
        mRepository.insert(question);
    }
}
