package com.example.exammobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ReportFragment extends Fragment {
    public ReportFragment() {
        // Required empty public constructor
    }
    public static ReportFragment newInstance(String param1, String param2) {
        ReportFragment fragment = new ReportFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_report, null);
        TextView textViewCount = root.findViewById(R.id.textViewBooksTotal);
        TextView textViewReportByDB = root.findViewById(R.id.textViewReportByDB);
        textViewCount.setText(String.valueOf(MainActivity.bookList.size()));
        textViewReportByDB.setText(ReportActivity.report);
        return root;
    }
}