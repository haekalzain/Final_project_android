package com.example.final_project.rest;

import com.example.final_project.model.BaseResponse;
import com.example.final_project.model.DataLoginCO;
import com.example.final_project.model.GetAkunNasabah;
import com.example.final_project.model.GetAndPostNasabah;
import com.example.final_project.model.GetListNasabah;
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

    @PUT("/financing-report/pay/{trxId}")
    Call<Pembayaran> putbayar(@Path("trxId") String trxId,
                              @Body JsonObject bayar);

    @PUT("/customers/edit/{id}")
    Call<GetAndPostNasabah> updateNasabah(@Path("id") String id,
                                          @Body JsonObject h);

    @POST("/financing/account/input")
    Call<ResponMiddleware> createPeminjaman(@Body JsonObject pinjam);

    @GET("/financing/account/7987edd7-4a75-4102-b202-00c27b09b636")
    Call<GetAkunNasabah> getAkunNasabah ();
}
