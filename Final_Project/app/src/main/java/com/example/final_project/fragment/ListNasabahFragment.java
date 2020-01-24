package com.example.final_project.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.adapter.NasabahAdapter;
import com.example.final_project.controller.DetailNasabahActivity;
import com.example.final_project.controller.NasabahActivity;
import com.example.final_project.model.GetListNasabah;
import com.example.final_project.model.Nasabah;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListNasabahFragment extends Fragment {

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
        getListNasabah();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list_nasabah, container, false);
    }

    void initData() {
        listNasabah = new ArrayList();
        listNasabah.clear();
        nasabahAdapter = new NasabahAdapter(getActivity().getApplicationContext(),listNasabah);
        nasabahListView.setAdapter(nasabahAdapter);
        nasabahAdapter.notifyDataSetChanged();
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);

    }

    void findViewById(View v) {
        nasabahListView = (ListView) v.findViewById(R.id.listnasabah);

    }

    void getListNasabah() {
        Call<GetListNasabah> nasabahCall = mApiInterface.getListNasabah();
        nasabahCall.enqueue(new Callback<GetListNasabah>() {
            @Override
            public void onResponse(Call<GetListNasabah> call, Response<GetListNasabah> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getActivity().getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                    Log.e("cccc",response.body().getListDataNasabah().getListDataNasabah().get(0).getEmail());
                    List<Nasabah> listNasabahTemp = response.body().getListDataNasabah().getListDataNasabah();
                    listNasabah.clear();
                    listNasabah.addAll(listNasabahTemp);
                    nasabahAdapter.notifyDataSetChanged();

                    nasabahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent a = new Intent(getActivity(), DetailNasabahActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("phone", listNasabah.get(position).getPhone());
                            bundle.putString("nama", listNasabah.get(position).getName());
                            bundle.putString("alamat", listNasabah.get(position).getAddress());
                            bundle.putString("id", listNasabah.get(position).getId());
                            bundle.putString("email", listNasabah.get(position).getEmail());
                            a.putExtras(bundle);
                            startActivity(a);
                            getActivity();

                        }
                    });
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetListNasabah> call, Throwable t) {
                Log.e("Error :",t.toString());
            }
        });
    }
}