package com.example.final_project.res;

import com.example.final_project.model.DataCo;
import com.example.final_project.model.DataLoginCO;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("users/login")
    Call<DataLoginCO> postCo(@Body JsonObject O);

    @GET ("employee/all")
    Call<DataCo> getCo(@Body JsonObject O);
}
