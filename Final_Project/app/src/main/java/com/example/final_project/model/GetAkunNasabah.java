package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAkunNasabah extends BaseResponse {
    @SerializedName("data")
    List<JadwalBayar> jadwalBayar;

    public List<JadwalBayar> getJadwalBayar() {
        return jadwalBayar;
    }

    public void setJadwalBayar(List<JadwalBayar> jadwalBayar) {
        this.jadwalBayar = jadwalBayar;
    }
}
