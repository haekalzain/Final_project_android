package com.example.final_project.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.final_project.R;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;


public class DaftarPeminjamanFragment extends Fragment {
    ApiInterface mApiInterface;
    Button datepicker,btndaftarpeminjaman;
    TextView cektanggal;
    EditText editjumlahpeminjaman,idcopeminjaman,idnasabahpeminjaman;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById(view);
        initData();
        onClick();
    }

     void onClick() {
         datepicker.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 DialogFragment newFragment = new SelectDateFragment();
                 newFragment.show(getFragmentManager(), "DatePicker");
             }
         });
         btndaftarpeminjaman.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
    }

    void initData() {
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
    }

    void findViewById(View view) {
        datepicker = (Button) view.findViewById(R.id.datepicker);
        cektanggal = (TextView) view.findViewById(R.id.cektanggal);
        editjumlahpeminjaman= (EditText) view.findViewById(R.id.editjumlahpeminjaman);
        idcopeminjaman= (EditText) view.findViewById(R.id.idcopeminjaman);
        idnasabahpeminjaman= (EditText) view.findViewById(R.id.idnasabahpeminjaman);
        btndaftarpeminjaman =(Button) view.findViewById(R.id.btndaftarpeminjaman);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_daftar_peminjaman, container, false);
    }
}
