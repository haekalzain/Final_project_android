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
import com.example.final_project.fragment.DaftarPembayaranFragment;
import com.example.final_project.fragment.DaftarPeminjamanFragment;
import com.example.final_project.fragment.ListPembayaranFragment;
import com.example.final_project.fragment.ListPeminjamanFragment;

public class PembayaranActivity extends AppCompatActivity {
    FrameLayout framepembayaran;
    FragmentTransaction fm;
    LinearLayout lldatapembayaran,lldaftarpembayaran;
    TextView datapembayaran,daftarpembayaran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        findViewById();
        initAction();
        lldatapembayaran.callOnClick();
    }

     void initAction() {

         lldatapembayaran.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepembayaran,new ListPembayaranFragment());
                 fm.commit();
                 lldatapembayaran.setBackgroundColor(Color.parseColor("white"));
                 datapembayaran.setTextColor(Color.parseColor("#f3801f"));
                 lldaftarpembayaran.setBackgroundColor(Color.TRANSPARENT);
                 daftarpembayaran.setTextColor(Color.parseColor("white"));
             }
         });
         lldaftarpembayaran.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fm = getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.framepembayaran,new DaftarPembayaranFragment());
                 fm.commit();
                 lldaftarpembayaran.setBackgroundColor(Color.parseColor("white"));
                 daftarpembayaran.setTextColor(Color.parseColor("#f3801f"));
                 lldatapembayaran.setBackgroundColor(Color.TRANSPARENT);
                 datapembayaran.setTextColor(Color.parseColor("white"));
             }
         });
    }
    void findViewById() {
        framepembayaran=findViewById(R.id.framepembayaran);
        lldatapembayaran=findViewById(R.id.lldatapembayaran);
        lldaftarpembayaran=findViewById(R.id.lldaftarpembayaran);
        datapembayaran=findViewById(R.id.datapembayaran);
        daftarpembayaran=findViewById(R.id.daftarpembayaran);
    }
}
