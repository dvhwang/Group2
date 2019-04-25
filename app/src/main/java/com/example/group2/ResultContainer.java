package com.example.group2;


import android.provider.BaseColumns;

public final class ResultContainer {

    private ResultContainer(){

    }

    //Creating a table to store the results
    public static class ResultTable implements BaseColumns {
        public static final String TABLE_NAME = "result_table";
        public static final String COLUMN_RESULT = "result";
    }



}
