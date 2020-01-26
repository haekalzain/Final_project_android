package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

public class GetAkunNasabah extends BaseResponse {
    @SerializedName("data")
    AkunPeminjaman akunPeminjaman;

    public AkunPeminjaman getAkunPeminjaman() {
        return akunPeminjaman;
    }

    public void setAkunPeminjaman(AkunPeminjaman akunPeminjaman) {
        this.akunPeminjaman = akunPeminjaman;
    }
}
