package com.example.examtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PortsFragment extends Fragment {

    Button btn_report, btn_import, btn_export;

    public PortsFragment() {
        // Required empty public constructor
    }

    public static PortsFragment newInstance() {
        return new PortsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ports, null);

        btn_report = v.findViewById(R.id.btn_report);
        btn_import = v.findViewById(R.id.btn_import);
        btn_export = v.findViewById(R.id.btn_export);

        btn_report.setOnClickListener((MainActivity)getActivity());
        btn_import.setOnClickListener((MainActivity)getActivity());
        btn_export.setOnClickListener((MainActivity)getActivity());

        return v;
    }
}