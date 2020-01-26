package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pembayaran extends  BaseResponse {
    @SerializedName("data")
    PutBayar putBayar;

    public PutBayar getPutBayar() {
        return putBayar;
    }

    public void setPutBayar(PutBayar putBayar) {
        this.putBayar = putBayar;
    }
}
