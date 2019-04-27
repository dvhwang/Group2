package com.example.group2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FrameworkMain extends AppCompatActivity {
    //Variable to store the
    private boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framework_main);

        //Testing to see if the detail fragment has been activated
        if(findViewById(R.id.detail_container) != null){
            twoPane = true;
        }

        //Creating RecyclerView and introducing its necessary methods
        RecyclerView recyclerView = findViewById(R.id.frameworkList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Creating Adapter and setting the adapter to the RecyclerView
        RecyclerView.Adapter adapter = new FrameworkAdapter(this, Framework.getDummyFrameworks(), twoPane);
        recyclerView.setAdapter(adapter);
    }
}
