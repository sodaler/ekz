package com.example.examtest;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FilterFragment extends DialogFragment {

    Button btn_enter, btn_cancel;
    Spinner spinner;
    EditText fld_age;

    View.OnClickListener listener;

    ArrayAdapter<String> adapter;
    public int age = 0;

    public FilterFragment() {
        // Required empty public constructor
    }


    public static FilterFragment newInstance(View.OnClickListener onclck) {
        FilterFragment fragment = new FilterFragment();
        fragment.listener = onclck;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filter, null);

        spinner = v.findViewById(R.id.spin_option);
        fld_age = v.findViewById(R.id.fld_age);
        btn_enter = v.findViewById(R.id.btn_enter);
        btn_cancel = v.findViewById(R.id.btn_cancel);

        fld_age.setText(Integer.toString(age));

        String[] data = {">", "<", "="};

        adapter = new ArrayAdapter<>(this.getContext(),
                android.R.layout.simple_spinner_item,
                data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btn_enter.setOnClickListener(listener);
        btn_cancel.setOnClickListener(listener);

        return v;
    }

    public String getSelected() {
        return spinner.getSelectedItem().toString();
    }
}