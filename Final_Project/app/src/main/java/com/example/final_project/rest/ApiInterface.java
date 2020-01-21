package com.example.final_project.rest;

import com.example.final_project.model.BaseResponse;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/login")
    Call<BaseResponse> createNasabah (@Body JsonObject o);
}
