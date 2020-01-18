package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.final_project.fragment.DaftarNasabahFragment;
import com.example.final_project.fragment.DaftarPeminjamanFragment;
import com.example.final_project.fragment.ListNasabahFragment;
import com.example.final_project.fragment.ListPeminjamanFragment;

public class PeminjamanActivity extends AppCompatActivity {
    FrameLayout framepeminjaman;
    FragmentTransaction fm;
    LinearLayout lldatapeminjaman,lldaftarpeminjaman;
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
                 lldatapeminjaman.setBackgroundColor(Color.parseColor("white"));
                 datapeminjaman.setTextColor(Color.parseColor("#f3801f"));
                 lldaftarpeminjaman.setBackgroundColor(Color.TRANSPARENT);
                 daftarpeminjaman.setTextColor(Color.parseColor("white"));
             }
         });
         lldaftarpeminjaman.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepeminjaman,new DaftarPeminjamanFragment());
                 fm.commit();
                 lldaftarpeminjaman.setBackgroundColor(Color.parseColor("white"));
                 daftarpeminjaman.setTextColor(Color.parseColor("#f3801f"));
                 lldatapeminjaman.setBackgroundColor(Color.TRANSPARENT);
                 datapeminjaman.setTextColor(Color.parseColor("white"));
             }
         });
    }

    void findViewById() {
        framepeminjaman=findViewById(R.id.framepeminjaman);
        lldatapeminjaman=findViewById(R.id.lldatapeminjaman);
        lldaftarpeminjaman=findViewById(R.id.lldaftarpeminjaman);
        datapeminjaman=findViewById(R.id.datapeminjaman);
        daftarpeminjaman=findViewById(R.id.daftarpeminjaman);
    }
}
