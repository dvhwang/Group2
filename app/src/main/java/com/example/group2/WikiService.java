package com.example.group2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WikiService {

    @GET("api.php")
    Call<WikiResponse> getWiki()


}
