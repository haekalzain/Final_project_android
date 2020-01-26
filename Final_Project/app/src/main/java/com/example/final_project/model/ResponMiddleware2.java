package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponMiddleware2 extends BaseResponse {
    @SerializedName("data")
    AkunPeminjaman akunPeminjaman;

    public AkunPeminjaman getAkunPeminjaman() {
        return akunPeminjaman;
    }

    public void setAkunPeminjaman(AkunPeminjaman akunPeminjaman) {
        this.akunPeminjaman = akunPeminjaman;
    }
}
