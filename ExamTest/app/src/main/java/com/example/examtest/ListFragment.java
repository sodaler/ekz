package com.example.examtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListFragment extends Fragment {

    DbList db;
    ListView lst_view;
    ArrayAdapter<String> adapter;
    Button btn_add, btn_edit, btn_delete;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, null);

        lst_view = v.findViewById(R.id.list);
        btn_add = v.findViewById(R.id.btn_add);
        btn_edit = v.findViewById(R.id.btn_edit);
        btn_delete = v.findViewById(R.id.btn_delete);

        btn_add.setOnClickListener((MainActivity)getActivity());
        btn_edit.setOnClickListener((MainActivity)getActivity());
        btn_delete.setOnClickListener((MainActivity)getActivity());

        db = DbList.getInstance();
        adapter = new ArrayAdapter<String>(
                this.getContext(),
                android.R.layout.simple_list_item_single_choice,
                db.getAllNames());
        lst_view.setAdapter(adapter);
        lst_view.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        // Inflate the layout for this fragment
        return v;
    }

    public String getSelected() {
        if (lst_view.getCheckedItemPosition() == AdapterView.INVALID_POSITION) return null;
        return adapter.getItem(lst_view.getCheckedItemPosition());
    }

    public void add(String nm, int ag) {
        db.addPatient(new Patient(nm, ag));
        adapter.add(nm);
    }

    public void edit(String nm, int ag) {
        Patient pat = db.getByName(nm);
        pat.age = ag;
    }

    public void delete() {
        String name = adapter.getItem(lst_view.getCheckedItemPosition());
        db.removePatient(name);
        adapter.remove(name);
    }

    public void reloadData() {
        adapter.clear();
        for (Patient p : db.getAll())
            adapter.add(p.name);
    }
}