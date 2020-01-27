package com.example.final_project.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.controller.MainActivity;
import com.example.final_project.controller.PeminjamanActivity;
import com.example.final_project.model.Pembayaran;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DaftarPembayaranFragment extends Fragment {
EditText kodebayar,namanasabahbayar;
TextView nikcobayar;
Button btnpembayaran;
ApiInterface mApiInterface;
String trxId;
Preference preference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_pembayaran, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById(view);
        initData();
        onClick();
    }

    void onClick() {
        btnpembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject bayar= new JsonObject();
                bayar.addProperty("accountName",namanasabahbayar.getText().toString());
                bayar.addProperty("nik",nikcobayar.getText().toString());

                trxId = kodebayar.getText().toString();
                Call<Pembayaran> nasabahCall = mApiInterface.putbayar(trxId,bayar);
                nasabahCall.enqueue(new Callback<Pembayaran>() {
                    @Override
                    public void onResponse(Call<Pembayaran> call, Response<Pembayaran> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getActivity().getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                            Intent a = new Intent(getActivity(), MainActivity.class);
                            startActivity(a);
                            getActivity().finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pembayaran> call, Throwable t) {
                        Log.e("Error :",t.toString());

                    }
                });
            }
        });
    }

    void initData() {
        mApiInterface =ApiClient.getClient(getContext()).create(ApiInterface.class);
        nikcobayar.setText(preference.getNik(getContext()));
    }

    void findViewById(View view) {
        kodebayar= (EditText)view.findViewById(R.id.kodebayar);
        btnpembayaran = (Button) view.findViewById(R.id.btnpembayaran);
        nikcobayar= (TextView) view.findViewById(R.id.nikcobayar);
        namanasabahbayar=(EditText) view.findViewById(R.id.namanasabahbayar);
    }

}
