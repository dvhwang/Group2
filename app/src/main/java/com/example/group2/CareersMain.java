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

//Instantiate all variables and layout widgets

    private Button btn_mck;
    private Button btn_bain;
    private Button btn_bcg;
    private TextView Wiki_Summary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
		// Find all widgets and buttons using their unique ID from the OnCreate Method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_careers_main);

        btn_mck = findViewById(R.id.btn_mck);
        btn_bain = findViewById(R.id.btn_bain);
        btn_bcg = findViewById(R.id.btn_bcg);
        Wiki_Summary = findViewById(R.id.Wiki_Summary);
		
		
//Methods which set the link pertaining to specific Wikipedia articles based off the button clicked
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
            public void onClick(View v) {getWikiPage("Boston_Consulting_Group");
            }
        });


    }

   //This program downloads the JSON Wikipedia file
        // – title variable represents the unique section of each distinct url for specific pages
        OkHttpClient client = new OkHttpClient();
        String url = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + title;

        //Creates request object for making network calls
        Request request = new Request.Builder()
                .url(url)
                .build();

        //Use the client to create a Call object
        //Use enqueue method for asynchronous calls


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                //onFailure method invoked when HTTP call to Wikipedia fails
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final Response wikiResponse = response;
                //onResponse method invoked when HTTP call to Wikipedia is successful

                //In order to update the UI, the runOnUiThread() is used to sync with the UI thread
                WikiSearchActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String data = " ";

                        //Use try catch block to handle exceptions when retrieving body of Wikipedia page as a string

                        try{
                            data = wikiResponse.body().string();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        try{
                            String pagenumber = "";
                            //Iterator interface used to traverse collection of wiki pages
                            Iterator <String> iterator = new JSONObject(data).getJSONObject("query").getJSONObject("pages").keys();
                            while (iterator.hasNext()){
                                pagenumber = iterator.next();
                            }

                            //Because the content summary is in the extract object of JSON file,
                            // must use the get() method to retrieve all objects up to and
                            // including the extract object so as to not return any extra
                            // characters from JSON file

                            data = new JSONObject(data).getJSONObject("query").getJSONObject("pages").getJSONObject(pagenumber).getString("extract");
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                        //Change the textview here
                        text_wiki_sum.setText(data);
                    }
                });

            }
        });
    }

}

