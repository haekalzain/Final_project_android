package com.example.final_project.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.final_project.R;

import java.util.Calendar;


public class SelectDateFragment extends DialogFragment  implements DatePickerDialog.OnDateSetListener {
    TextView cektanggal;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(getActivity(),this,yy, mm, dd);
        DatePicker dp = dpd.getDatePicker();
        dp.setMinDate(calendar.getTimeInMillis()+86400000);
        return  dpd;
    }

    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
         cektanggal= (TextView)getActivity(). findViewById(R.id.cektanggal);
        populateSetDate(yy, mm+1, dd);
    }
    public void populateSetDate(int year, int month, int day) {
        cektanggal.setText(year+"-"+month+"-"+day);
    }


}
