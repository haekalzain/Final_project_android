package com.example.final_project.res;

import com.example.final_project.model.baseResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("users/login")
    Call<baseResponse> postCo(@Body JsonObject O);
}
