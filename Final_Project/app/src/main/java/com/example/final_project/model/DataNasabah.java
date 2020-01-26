package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataNasabah {

    @SerializedName("content")
    List<Nasabah> listDataNasabah;

//    @SerializedName("pageable")

    public List<Nasabah> getListDataNasabah() {
        return listDataNasabah;
    }

    public void setListDataNasabah(List<Nasabah> listDataNasabah) {
        this.listDataNasabah = listDataNasabah;
    }
}
