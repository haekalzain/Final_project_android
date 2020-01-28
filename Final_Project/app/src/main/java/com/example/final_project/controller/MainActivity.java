package com.example.final_project.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.final_project.R;
import com.example.final_project.model.DataCo;
import com.example.final_project.model.Pembayaran;
import com.example.final_project.model.ResponCo;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

     String Nik, Name ;
    private DataCo co ;
    ApiInterface mApiInterface;
    ImageButton Nasabah, Finance, Payment, Setting;
    TextView nama, nik;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApiInterface= ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);

        findViewById();
        onClick();
        initData();
    }

    void initData(){
        Nik=( new Preference().getNik(getApplicationContext()));
        Log.e("aaaa",Nik.toString());
        Call<ResponCo> CoCall = mApiInterface.getCo(Nik);
        CoCall.enqueue((new Callback<ResponCo>() {
            @Override
            public void onResponse(Call<ResponCo> call, Response<ResponCo> response) {
                if (response.isSuccessful()) {
                    Log.e("zzzz",response.message().toString());

                    co = response.body().getCo();
                    Bundle bundle = new Bundle();
                    nama.setText(co.getName());
                    nik.setText(co.getNik());
                } else {
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponCo> call, Throwable t) {

            }
        }));
    }

    void findViewById(){
        Nasabah = findViewById(R.id.btnNasabah);
        Finance = findViewById(R.id.btnFinance);
        Payment = findViewById(R.id.btnPayment);
        Setting = findViewById(R.id.btnSetting);
        nama = findViewById(R.id.NamaCo);
        nik = findViewById(R.id.NikCo);
    }


    void onClick() {
        //forgotPassword
        Nasabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NasabahActivity.class);
                startActivity(intent);
            }
        });

        Finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PeminjamanActivity.class);
                startActivity(intent);
            }
        });

        Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PembayaranActivity.class);
                startActivity(intent);
            }
        });

        Setting.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(MainActivity.this, DetailCoActivity.class);
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
    }
}
