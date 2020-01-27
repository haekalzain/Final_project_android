package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.final_project.fragment.DaftarPembayaranFragment;
import com.example.final_project.fragment.DaftarPeminjamanFragment;
import com.example.final_project.fragment.ListPembayaranFragment;
import com.example.final_project.fragment.ListPeminjamanFragment;

public class PembayaranActivity extends AppCompatActivity {
    FrameLayout framepembayaran;
    FragmentTransaction fm;
    LinearLayout lldatapembayaran,lldaftarpembayaran,efekdatapembayaran,efekdaftarpembayaran,back;
    TextView datapembayaran,daftarpembayaran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        findViewById();
        initAction();
        lldaftarpembayaran.callOnClick();
    }

     void initAction() {

         lldatapembayaran.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepembayaran,new ListPembayaranFragment());
                 fm.commit();
                 efekdatapembayaran.setVisibility(View.VISIBLE);
                 efekdaftarpembayaran.setVisibility(View.GONE);
             }
         });
         lldaftarpembayaran.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepembayaran,new DaftarPembayaranFragment());
                 fm.commit();
                 efekdaftarpembayaran.setVisibility(View.VISIBLE);
                 efekdatapembayaran.setVisibility(View.GONE);

             }
         });

         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(PembayaranActivity.this, MainActivity.class);
                 startActivity(intent);
             }
         });

    }
    void findViewById() {
        framepembayaran=findViewById(R.id.framepembayaran);
        lldatapembayaran=findViewById(R.id.lldatapembayaran);
        lldaftarpembayaran=findViewById(R.id.lldaftarpembayaran);
        datapembayaran=findViewById(R.id.datapembayaran);
        daftarpembayaran=findViewById(R.id.daftarpembayaran);
        efekdatapembayaran=findViewById(R.id.efekdatapembayaran);
        efekdaftarpembayaran=findViewById(R.id.efekdaftarpembayaran);
        back = findViewById(R.id.back);
    }
}
