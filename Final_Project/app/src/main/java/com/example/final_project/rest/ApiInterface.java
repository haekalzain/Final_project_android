package com.example.final_project.rest;

import com.example.final_project.model.BaseResponse;
import com.example.final_project.model.DataLoginCO;
import com.example.final_project.model.GetAndPostNasabah;
import com.example.final_project.model.GetListNasabah;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("users/login")
    Call<DataLoginCO> postCo(@Body JsonObject O);

    @GET("/customers/all")
    Call<GetListNasabah> getListNasabah();

    @POST("/customers/add")
    Call<GetAndPostNasabah> createNasabah(@Body JsonObject o);
}