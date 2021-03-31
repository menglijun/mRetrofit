package com.example.administrator.myretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {
    @GET("user/libai/respo")
    Call<List<Repro>> getRespos();
}
