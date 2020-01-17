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
import com.example.final_project.fragment.ListNasabahFragment;

public class NasabahActivity extends AppCompatActivity {
    FrameLayout framenasabah;
    FragmentTransaction fm;
    LinearLayout lldatanasabah,lldaftarnasabah;
    TextView datanasabah,daftarnasabah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasabah);
        findViewById();
        initAction();
        lldatanasabah.callOnClick();

    }

     void initAction() {
    lldatanasabah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.framenasabah,new ListNasabahFragment());
            fm.commit();
            lldatanasabah.setBackgroundColor(Color.parseColor("white"));
            datanasabah.setTextColor(Color.parseColor("#f3801f"));
            lldaftarnasabah.setBackgroundColor(Color.TRANSPARENT);
            daftarnasabah.setTextColor(Color.parseColor("white"));
        }
    });
    lldaftarnasabah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.framenasabah,new DaftarNasabahFragment());
            fm.commit();
            lldaftarnasabah.setBackgroundColor(Color.parseColor("white"));
            daftarnasabah.setTextColor(Color.parseColor("#f3801f"));
            lldatanasabah.setBackgroundColor(Color.TRANSPARENT);
            datanasabah.setTextColor(Color.parseColor("white"));
        }
    });
    }

    void findViewById() {
        framenasabah=findViewById(R.id.framenasabah);
        lldatanasabah=findViewById(R.id.lldatanasabah);
        lldaftarnasabah=findViewById(R.id.lldaftarnasabah);
        datanasabah=findViewById(R.id.datanasabah);
        daftarnasabah=findViewById(R.id.daftarnasabah);
    }
}
