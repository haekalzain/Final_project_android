package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.final_project.util.Preference;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailNasabahActivity extends AppCompatActivity {
    String phone,nama,alamat,id,email,nikco;
    EditText namanasabahupdate,emailnasabahupdate,alamatnasabahupdate,nomorhpnasabahupdate;
    Button btnupdatenasabah;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nasabah);
        mApiInterface= ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
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
                try {
                    Toast.makeText(getApplicationContext(), "This is my Toast message!",
                            Toast.LENGTH_LONG).show();
                    JsonObject h = new JsonObject();
                    h.addProperty("name",namanasabahupdate.getText().toString());
                    h.addProperty("email",emailnasabahupdate.getText().toString());
                    h.addProperty("address",alamatnasabahupdate.getText().toString());
                    h.addProperty("phone",alamatnasabahupdate.getText().toString());
                    h.addProperty("customer_nik",nikco);
                    Log.e("bbbbchhh",h.toString());
                    Call<GetAndPostNasabah> nasabahCall=mApiInterface.updateNasabah(id,h);
                    nasabahCall.enqueue(new Callback<GetAndPostNasabah>() {
                        @Override
                        public void onResponse(Call<GetAndPostNasabah> call, Response<GetAndPostNasabah> response) {
                            if(response.isSuccessful()){
                                Log.e("aaaa",response.toString());
                                Intent intent= new Intent(DetailNasabahActivity.this,NasabahActivity.class);
                                startActivity(intent);

                                Toast.makeText(getApplicationContext(),response.code(),Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<GetAndPostNasabah> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }catch (Exception e){
                    System.out.println("Error"+e.toString());
                }
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
        Bundle bundle = getIntent().getExtras();
        phone = bundle.getString("phone");
        nama = bundle.getString("nama");
        alamat = bundle.getString("alamat");
        id = bundle.getString("id");
        email = bundle.getString("email");
        nikco=bundle.getString("customer_nik");
        Log.e("eeee",id);
        Log.e("hhh",nikco);
    }
}
