package com.example.exammobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.exammobile.Database.AppDatabase;
import com.example.exammobile.Database.Book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.exammobile.Database.BookDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Book> bookList = new ArrayList<>();
    private static final String FILE_NAME = "books.json";
    private BookDao bookDao;

    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //loadDataFromJSON();

        db = AppDatabase.getInstance(this);
        bookDao = db.bookDao();
        loadData();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_top_container, new BookFragment())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frragment_bottom_container, new FilterFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void addBook(Book book) {
        //bookList.add(book);
        //saveDataToJSON();

        new Thread(() -> {
            AppDatabase db = AppDatabase.getInstance(this);
            db.bookDao().insertBook(book);
            loadData();
        }).start();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_top_container, new BookFragment())
                .commit();
    }

    public void updateBook(int index, Book book) {
        //bookList.set(index, book);
        //saveDataToJSON();

        new Thread(() -> {
            AppDatabase db = AppDatabase.getInstance(this);
            db.bookDao().updateBook(book);
            loadData();
        }).start();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_top_container, new BookFragment())
                .commit();
    }

    public Book getBook(int index) {
        return bookList.get(index);
    }
    public void deleteBook(int index){
        new Thread(() -> {
            AppDatabase db = AppDatabase.getInstance(this);
            db.bookDao().deleteBook(bookList.get(index));
            loadData();
        }).start();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_top_container, new BookFragment())
                .commit();

        //bookList.remove(index);
        //saveDataToJSON();
    }

    public void saveDataToJSON() {
        Gson gson = new Gson();
        String json = gson.toJson(bookList);

        try (FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromJSON() {
        try (FileInputStream fis = openFileInput(FILE_NAME)) {
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            String json = new String(buffer);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Book>>() {}.getType();
            bookList = gson.fromJson(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        new Thread(() -> {
            bookList = db.bookDao().getAllBooks();
        }).start();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_top_container, new BookFragment())
                .commit();
    }
}