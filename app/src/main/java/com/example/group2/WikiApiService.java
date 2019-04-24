package com.example.group2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WikiApiService {

    private static WikiApiService instance = null;
    private Retrofit retrofit;
    private WikiService WikiService;
    private final String baseUrl = "https://en.wikipedia.org/w/";
    //public static final String API_KEY = "0cafa2ad34d6df8c2e863a59c773394e";

    private WikiApiService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Gson gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        WikiService = retrofit.create(WikiService.class);
    }

    public static WikiApiService getInstance() {
        if (instance == null) {
            instance = new WikiApiService();
        }
        return instance;
    }

    public WikiService getBeerService() {
        return WikiService;
    }




}
