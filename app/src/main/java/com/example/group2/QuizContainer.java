package com.example.group2;

import android.provider.BaseColumns;

/*Modified Code from:
Author: Coding in Flow
Year: 2017
Link: https://www.youtube.com/watch?v=5ISNPFmuOU8
*/

//Container for the different constants required for the SQLite operations
public final class QuizContainer {

    //Creating constant for the Question table
    //BaseColumns provides the id which will increment each time a new question is entered
    public static class QuestionTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NO = "answer_no";
    }
}
