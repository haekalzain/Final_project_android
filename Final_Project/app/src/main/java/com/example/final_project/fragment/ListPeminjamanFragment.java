package com.example.final_project.fragment;

import android.content.Context;
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
import android.widget.ListView;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.final_project.adapter.ListPeminjamanAdapter;
import com.example.final_project.adapter.NasabahAdapter;
import com.example.final_project.model.AkunPeminjaman;
import com.example.final_project.model.GetAkunNasabah;
import com.example.final_project.model.JadwalBayar;
import com.example.final_project.model.Nasabah;
import com.example.final_project.model.ResponMiddleware;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListPeminjamanFragment extends Fragment {
    ApiInterface mApiInterface;
    EditText searchpeminjaman;
    Button btnsearchakunnasabah;
   ListView listkodebayar;
   ListPeminjamanAdapter listPeminjamanAdapter;
    private List<JadwalBayar> jadwalBayarList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mApiInterface= ApiClient.getClient(getContext()).create(ApiInterface.class);
        findViewById(view);
        initData();
        OnClick();

    }

    void initData() {
        jadwalBayarList = new ArrayList();
        jadwalBayarList.clear();
        listPeminjamanAdapter = new ListPeminjamanAdapter(getActivity().getApplicationContext(),jadwalBayarList);
        listkodebayar.setAdapter(listPeminjamanAdapter);
        listPeminjamanAdapter.notifyDataSetChanged();
        searchpeminjaman.setText(Preference.getIdnasabah(getActivity().getApplicationContext()));

    }

    void OnClick() {
        btnsearchakunnasabah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String id =searchpeminjaman.getText().toString();
            Log.e("aaaa","aaaaa");
            Call<GetAkunNasabah> responMiddlewareCall = mApiInterface.getAkunNasabah(id);
            Log.e("bbbb",responMiddlewareCall.toString());
            responMiddlewareCall.enqueue(new Callback<GetAkunNasabah>() {
                @Override
                public void onResponse(Call<GetAkunNasabah> call, Response<GetAkunNasabah> response) {
                    Log.e("gggg",response.body().getJadwalBayar().get(0).getTrxId());
                    List<JadwalBayar> listkode = response.body().getJadwalBayar();
                    jadwalBayarList.clear();
                    jadwalBayarList.addAll(listkode);
                    listPeminjamanAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<GetAkunNasabah> call, Throwable t) {

                }
            });
        }
    });
    }


    void findViewById(View view) {
        btnsearchakunnasabah= (Button) view.findViewById(R.id.seacrhakunnasabah);
        searchpeminjaman =(EditText) view.findViewById(R.id.searchpeminjaman);
        listkodebayar =(ListView) view.findViewById(R.id.listkodebayar);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_peminjaman, container, false);
    }
}
