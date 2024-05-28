package com.example.exammobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.exammobile.Database.Book;

public class BookEditFragment extends Fragment {
    private static final String ARG_BOOK_INDEX = "book_index";
    private int bookIndex;

    public BookEditFragment() {
        // Required empty public constructor
    }

    public static BookEditFragment newInstance(int index) {
        BookEditFragment fragment = new BookEditFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BOOK_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookIndex = getArguments().getInt(ARG_BOOK_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_book_edit, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        Book book = mainActivity.getBook(bookIndex);


        Button buttonEdit = root.findViewById(R.id.buttonEdit);
        Button buttonDelete = root.findViewById(R.id.buttonDelete);
        Button buttonBack = root.findViewById(R.id.buttonEditBack);
        EditText editTextName = root.findViewById(R.id.editTextEditBookName);
        EditText editTextAuthor = root.findViewById(R.id.editTextEditBookAuthor);
        EditText editTextIzdName = root.findViewById(R.id.editTextEditIzdName);
        EditText editTextIzdDate = root.findViewById(R.id.editTextEditDate);

        editTextName.setText(book.getName());
        editTextAuthor.setText(book.getAuthor());
        editTextIzdName.setText(book.getIzdName());
        editTextIzdDate.setText(book.getIzdDate());

        buttonEdit.setOnClickListener(v -> {
            book.setName(editTextName.getText().toString());
            book.setAuthor(editTextAuthor.getText().toString());
            book.setIzdName(editTextIzdName.getText().toString());
            book.setIzdDate(editTextIzdDate.getText().toString());
            mainActivity.updateBook(bookIndex, book);
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_top_container, new BookFragment())
                    .commit();
        });

        buttonDelete.setOnClickListener(v -> {
            mainActivity.deleteBook(bookIndex);
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_top_container, new BookFragment())
                    .commit();
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