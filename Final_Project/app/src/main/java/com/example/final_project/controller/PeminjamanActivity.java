package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.final_project.R;

import com.example.final_project.fragment.DaftarPeminjamanFragment;

import com.example.final_project.fragment.ListPeminjamanFragment;

public class PeminjamanActivity extends AppCompatActivity {
    FrameLayout framepeminjaman;
    FragmentTransaction fm;
    LinearLayout lldatapeminjaman,lldaftarpeminjaman,efekdatapeminjaman,efekdaftarpeminjaman,back;
    TextView datapeminjaman,daftarpeminjaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peminjaman);
        findViewById();
        initAction();
        lldatapeminjaman.callOnClick();
    }

     void initAction() {
         lldatapeminjaman.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepeminjaman,new ListPeminjamanFragment());
                 fm.commit();
                 efekdatapeminjaman.setVisibility(View.VISIBLE);
                 efekdaftarpeminjaman.setVisibility(View.GONE);
             }
         });
         lldaftarpeminjaman.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepeminjaman,new DaftarPeminjamanFragment());
                 fm.commit();
                 efekdaftarpeminjaman.setVisibility(View.VISIBLE);
                 efekdatapeminjaman.setVisibility(View.GONE);
             }
         });

         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(PeminjamanActivity.this, MainActivity.class);
                 startActivity(intent);
             }
         });

    }

    void findViewById() {
        framepeminjaman=findViewById(R.id.framepeminjaman);
        lldatapeminjaman=findViewById(R.id.lldatapeminjaman);
        lldaftarpeminjaman=findViewById(R.id.lldaftarpeminjaman);
        datapeminjaman=findViewById(R.id.datapeminjaman);
        daftarpeminjaman=findViewById(R.id.daftarpeminjaman);
        efekdatapeminjaman=findViewById(R.id.efekdatapeminjaman);
        efekdaftarpeminjaman=findViewById(R.id.efekdaftarpeminjaman);
        back=findViewById(R.id.back);

    }
}
