package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.fragment.DaftarPeminjamanFragment;
import com.example.final_project.model.GetAndPostNasabah;
import com.example.final_project.model.Nasabah;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailNasabahActivity extends AppCompatActivity {
String phone,nama,alamat,id,email;
TextView idnasabahupdate;
EditText namanasabahupdate,emailnasabahupdate,alamatnasabahupdate,nomorhpnasabahupdate;
Button btnupdatenasabah;
ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nasabah);
        findViewById();
        initData();
        onClick();
        getDataNasabah();
    }

    void getDataNasabah() {
        namanasabahupdate.setText(nama);
        alamatnasabahupdate.setText(alamat);
        nomorhpnasabahupdate.setText(phone);
        emailnasabahupdate.setText(email);
    }

    void onClick() {
        btnupdatenasabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button clicked",
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    void findViewById() {
        btnupdatenasabah=findViewById(R.id.btnnasabahupadte);
        emailnasabahupdate=findViewById(R.id.emailnasabahupdate);
        namanasabahupdate=findViewById(R.id.namanasabahupdate);
        nomorhpnasabahupdate=findViewById(R.id.nomorhpnasabahupdate);
        alamatnasabahupdate=findViewById(R.id.alamatnasabahupdate);

    }

    void initData() {
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
         Bundle bundle = getIntent().getExtras();
         phone = bundle.getString("phone");
         nama = bundle.getString("nama");
         alamat = bundle.getString("alamat");
         id = bundle.getString("id");
         email = bundle.getString("email");

    }
}
