package com.example.group2;

//Class to hold the Youtube API Key
public class YoutubeAPIHolder {

    public YoutubeAPIHolder() { }

    //Storing the API Key
    private static final String API_KEY = "AIzaSyBT-38WzeSc6623ef6VlSD4fSMyvPUN6eM";

    //Returning the API Key
    public static String getApiKey(){
        return API_KEY;
    }
}
