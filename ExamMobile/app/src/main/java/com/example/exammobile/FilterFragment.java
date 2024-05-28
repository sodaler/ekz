package com.example.exammobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FilterFragment extends Fragment {
    public FilterFragment() {
    }

    public static FilterFragment newInstance(String param1, String param2) {
        FilterFragment fragment = new FilterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_filter, null);
        MainActivity mainActivity = (MainActivity) getActivity();
        Button buttonAddBook = root.findViewById(R.id.button_add);
        Button buttonMakeReport = root.findViewById(R.id.buttonMakeReport);
        Button buttonLoadFromJSON = root.findViewById(R.id.buttonLoadFromJSON);
        Button buttonSaveToJSON = root.findViewById(R.id.buttonSaveToJSON);
        buttonAddBook.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_top_container, new BookAddFragment())
                    .commit();
        });
        buttonMakeReport.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ReportActivity.class);
            startActivity(intent);
        });
        buttonLoadFromJSON.setOnClickListener(v -> {
            mainActivity.loadDataFromJSON();
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_top_container, new BookFragment())
                    .commit();
        });
        buttonSaveToJSON.setOnClickListener(v -> {
            mainActivity.saveDataToJSON();
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_top_container, new BookFragment())
                    .commit();
        });
        return root;
    }
}