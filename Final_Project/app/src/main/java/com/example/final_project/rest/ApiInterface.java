package com.example.final_project.rest;

import com.example.final_project.model.BaseResponse;
import com.example.final_project.model.DataCo;
import com.example.final_project.model.DataLoginCO;
import com.example.final_project.model.GetAkunNasabah;
import com.example.final_project.model.GetAndPostNasabah;
import com.example.final_project.model.GetListNasabah;

import com.example.final_project.model.ResponCo;

import com.example.final_project.model.Pembayaran;
import com.example.final_project.model.ResponMiddleware;
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

    @GET("/customers/{nikCo}")
    Call<GetListNasabah> getListNasabah(@Path("nikCo") String nikCo);

    @POST("/customers/register")
    Call<GetAndPostNasabah> createNasabah(@Body JsonObject o);

    @GET("employee/{nik}")
    Call<ResponCo> getCo(@Path("nik") String Nik);

    @PUT("employee/edit/{nik}")
    Call<ResponCo> putCo(@Path("nik") String Nik,
                                  @Body JsonObject O);

    @PUT("/financing-report/pay/{trxId}")
    Call<Pembayaran> putbayar(@Path("trxId") String trxId,
                              @Body JsonObject bayar);

    @PUT("/customers/edit/{id}")
    Call<GetAndPostNasabah> updateNasabah(@Path("id") String id,
                                          @Body JsonObject h);

    @POST("/financing/account/input")
    Call<ResponMiddleware> createPeminjaman(@Body JsonObject pinjam);

    @GET("/financing/schedule/{id}")
    Call<GetAkunNasabah> getAkunNasabah (@Path("id") String id);
}
