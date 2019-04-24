package com.example.group2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        btn_mck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWikiPage("McKinsey_%26_Company");
            }
        });

        btn_bain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWikiPage("Bain_%26_Company");
            }
        });

        btn_bcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWikiPage("Boston_Consulting_Group");
            }
        });


    }

    public void getWikiPage(String title){

        OkHttpClient client = new OkHttpClient();
        String url = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + title;


        Request request = new Request.Builder()
                .url(url)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                //onFailure method invoked when HTTP call to Wikipedia fails
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final Response wikiResponse = response;

                CareersMain.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String data = " ";


                        try{
                            data = wikiResponse.body().string();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        try{
                            String pagenumber = "";

                            Iterator<String> iterator = new JSONObject(data).getJSONObject("query").getJSONObject("pages").keys();
                            while (iterator.hasNext()){
                                pagenumber = iterator.next();
                            }

                            data = new JSONObject(data).getJSONObject("query").getJSONObject("pages").getJSONObject(pagenumber).getString("extract");
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                        //Setting the TextView Here
                        Wiki_Summary.setText(data);
                    }
                });

            }
        });
    }

}

