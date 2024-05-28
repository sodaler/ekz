package com.example.examtest;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ModelFragment extends DialogFragment {

    Button btn_enter, btn_cancel;
    EditText fld_name, fld_age;

    View.OnClickListener listener;
    boolean nw = false;
    public String name = "";
    public int age = 0;

    public ModelFragment() {
        // Required empty public constructor
    }

    public static ModelFragment newInstance(View.OnClickListener onclck) {
        ModelFragment frag = new ModelFragment();
        frag.listener = onclck;
        frag.nw = true;
        return frag;
    }

    public static ModelFragment newInstance(String nm, int ag, View.OnClickListener onclck) {
        ModelFragment frag = new ModelFragment();
        frag.name = nm;
        frag.age = ag;
        frag.listener = onclck;
        frag.nw = false;
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_model, null);

        fld_name = v.findViewById(R.id.fld_name);
        fld_age = v.findViewById(R.id.fld_age);
        btn_enter = v.findViewById(R.id.btn_enter);
        btn_cancel = v.findViewById(R.id.btn_cancel);

        fld_name.setText(name);
        fld_age.setText(Integer.toString(age));

        btn_enter.setOnClickListener(listener);
        btn_cancel.setOnClickListener(listener);

        if (!nw) fld_name.setEnabled(false);

        return v;
    }

}