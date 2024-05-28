package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.entity.Item;

import java.io.Serializable;
import java.util.Objects;

public class ItemFragment extends DialogFragment {

    private EditText nameEditText;
    private Button saveButton;
    private Item item;
    private DatabaseHelper databaseHelper;

    public static ItemFragment newInstance(Item item) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());

        if (getArguments() != null) {
            item = (Item) getArguments().getSerializable("item");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        saveButton = view.findViewById(R.id.saveButton);

        if (item != null) {
            nameEditText.setText(item.getName());
        }

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            if (item == null) {
                databaseHelper.addItem(name);
            } else {
                databaseHelper.takeItem(item.getId(), name);
            }
            dismiss();
            ((MainActivity) requireActivity()).refreshList();
        });

        return view;
    }
}



