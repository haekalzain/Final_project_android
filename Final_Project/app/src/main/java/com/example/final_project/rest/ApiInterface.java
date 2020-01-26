package com.example.final_project.rest;

import com.example.final_project.model.BaseResponse;
import com.example.final_project.model.DataCo;
import com.example.final_project.model.DataLoginCO;
import com.example.final_project.model.GetAndPostNasabah;
import com.example.final_project.model.GetListNasabah;
import com.example.final_project.model.ResponCo;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("users/login")
    Call<DataLoginCO> postCo(@Body JsonObject O);

    @GET("/customers/all")
    Call<GetListNasabah> getListNasabah();

    @POST("/customers/add")
    Call<GetAndPostNasabah> createNasabah(@Body JsonObject o);

    @GET("employee/{nik}")
    Call<ResponCo> getCo(@Path("nik") String Nik);

    @PUT("employee/edit/{nik}")
    Call<ResponCo> putCo(@Path("nik") String Nik,
                                  @Body JsonObject O);

}