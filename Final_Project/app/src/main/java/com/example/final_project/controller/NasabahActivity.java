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
import com.example.final_project.fragment.DaftarNasabahFragment;
import com.example.final_project.fragment.ListNasabahFragment;

public class NasabahActivity extends AppCompatActivity {
    FrameLayout framenasabah;
    public FragmentTransaction fm;

    LinearLayout lldatanasabah,lldaftarnasabah,efekdatanasabah,efekdaftarnasabah,back;
    TextView datanasabah,daftarnasabah;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nasabah);
        findViewById();

        initAction();
        lldaftarnasabah.callOnClick();

    }



    void initAction() {
    lldatanasabah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.framenasabah,new ListNasabahFragment());
            fm.commit();
            efekdatanasabah.setVisibility(View.VISIBLE);
            efekdaftarnasabah.setVisibility(View.GONE);


        }
    });
    lldaftarnasabah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.framenasabah,new DaftarNasabahFragment());
            fm.commit();
            efekdaftarnasabah.setVisibility(View.VISIBLE);
            efekdatanasabah.setVisibility(View.GONE);
        }
    });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NasabahActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    void findViewById() {
        framenasabah=findViewById(R.id.framenasabah);
        lldatanasabah=findViewById(R.id.lldatanasabah);
        lldaftarnasabah=findViewById(R.id.lldaftarnasabah);
        datanasabah=findViewById(R.id.datanasabah);
        daftarnasabah=findViewById(R.id.daftarnasabah);
        efekdaftarnasabah=findViewById(R.id.efekdaftarnasabah);
        efekdatanasabah=findViewById(R.id.efekdatanasabah);
        back=findViewById(R.id.back);



    }
}
