package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.model.DataCo;
import com.example.final_project.model.ResponCo;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailCoActivity extends AppCompatActivity {
    LinearLayout back;
    EditText nama,nik,alamat,email;
    private DataCo co ;
    Button ubah,out;
    ApiInterface mApiInterface;
    String Name,Nik,Address,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_co);
        mApiInterface= ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
        findViewById();
        OnClick();
        initData();
    }

    void initData(){
        Bundle bundle = getIntent().getExtras();
        Name = bundle.getString("name");
        Nik = bundle.getString("nik");
        Address = bundle.getString("address");
        Email = bundle.getString("email");

        nama.setText(Name);
        nik.setText(Nik);
        alamat.setText(Address);
        email.setText(Email);
    }

    void findViewById(){
        nama = findViewById(R.id.namaCoTxt);
        nik=findViewById(R.id.NikCoTxt);
        alamat=findViewById(R.id.addressCoTxt);
        email=findViewById(R.id.emailCoTxt);
        ubah=findViewById(R.id.btnSave);
        out=findViewById(R.id.btnOut);
        back=findViewById(R.id.back);
    }

    void OnClick(){
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nik=( new Preference().getNik(getApplicationContext()));
                Log.e("aaaa",Nik.toString());
                Call<ResponCo> CoCall = mApiInterface.getCo(Nik);
                CoCall.enqueue(new Callback<ResponCo>() {
                    @Override
                    public void onResponse(Call<ResponCo> call, Response<ResponCo> response) {
                        if (response.isSuccessful()) {
                            Log.e("zzzz",response.message().toString());

                            co = response.body().getCo();
                            Intent intent = new Intent(DetailCoActivity.this, SettingActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("name",co.getName());
                            bundle.putString("nik",co.getNik());
                            bundle.putString("address",co.getAddres());
                            bundle.putString("email",co.getEmail());
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponCo> call, Throwable t) {
                        Log.e("aaaa",t.toString());

                    }
                });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
