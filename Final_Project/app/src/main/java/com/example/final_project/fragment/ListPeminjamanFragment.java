package com.example.final_project.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.final_project.R;
import com.example.final_project.adapter.NasabahAdapter;
import com.example.final_project.model.Nasabah;
import com.example.final_project.rest.ApiInterface;

import java.util.List;


public class ListPeminjamanFragment extends Fragment {
    ListView nasabahListView;
    NasabahAdapter nasabahAdapter;
    private List<Nasabah> listNasabah;
    ApiInterface mApiInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById(view);
        initData();
        getListPeminjaman();
    }

     void getListPeminjaman() {
    }

    void initData() {
    }

    void findViewById(View view) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_peminjaman, container, false);
    }


}
