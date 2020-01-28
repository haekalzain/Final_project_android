package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAndPostNasabah extends BaseResponse {
    @SerializedName("data")
    Nasabah nasabah;

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }
}
