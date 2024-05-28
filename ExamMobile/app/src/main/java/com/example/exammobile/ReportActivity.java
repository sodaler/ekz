package com.example.exammobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.exammobile.Database.AppDatabase;
import com.example.exammobile.Database.AuthorBookCount;
import com.example.exammobile.Database.Book;
import com.example.exammobile.Database.BookDao;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    public static List<Book> bookList = new ArrayList<>();

    public static List<AuthorBookCount> authorBookCounts = new ArrayList<>();

    public static String report = "";
    private BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        AppDatabase db = AppDatabase.getInstance(this);
        bookDao = db.bookDao();
        new Thread(() -> {
            authorBookCounts = bookDao.getBookCountByAuthor();
            for (AuthorBookCount abc : authorBookCounts) {
                report += "Автор: " + abc.author + ", Количество книг: " + abc.bookCount + "\n";
            }
        }).start();
        bookList = MainActivity.bookList;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_report_container, new ReportFragment())
                .commit();
    }
}