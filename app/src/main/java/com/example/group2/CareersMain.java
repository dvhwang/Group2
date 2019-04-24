package com.example.group2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CareersMain extends AppCompatActivity {

    private Button btn_mck;
    private Button btn_bain;
    private Button btn_bcg;
    private TextView Wiki_Summary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_careers_main);

        btn_mck = findViewById(R.id.btn_mck);
        btn_bain = findViewById(R.id.btn_bain);
        btn_bcg = findViewById(R.id.btn_bcg);
        Wiki_Summary = findViewById(R.id.Wiki_Summary);
        
    }
}
