package com.example.exammobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.exammobile.Database.Book;

public class BookAddFragment extends Fragment {
    public BookAddFragment() {
    }

    public static BookAddFragment newInstance() {
        BookAddFragment fragment = new BookAddFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_book_add, null);
        MainActivity mainActivity = (MainActivity) getActivity();
        Button buttonAddToList = root.findViewById(R.id.buttonAdd);
        Button buttonBack = root.findViewById(R.id.buttonAddBack);
        EditText editTextName = root.findViewById(R.id.editTextAddBookName);
        EditText editTextAuthor = root.findViewById(R.id.editTextAddBookAuthor);
        EditText editTextIzdName = root.findViewById(R.id.editTextAddIzdName);
        EditText editTextIzdDate = root.findViewById(R.id.editTextAddDate);
        buttonAddToList.setOnClickListener(v->{
            if(!editTextName.getText().equals("")
                    && !editTextAuthor.getText().equals("")
                    && !editTextIzdName.getText().equals("")
                    && !editTextIzdDate.getText().equals("")){
                Book book = new Book(editTextName.getText().toString(),
                        editTextAuthor.getText().toString(),
                        editTextIzdName.getText().toString(),
                        editTextIzdDate.getText().toString());
                mainActivity.addBook(book);
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_top_container, new BookFragment())
                        .commit();
            }
        });
        buttonBack.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_top_container, new BookFragment())
                    .commit();
        });
        return root;
    }
}