package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ReportActivity extends AppCompatActivity {

    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listView = findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);

        int[] report = databaseHelper.getReport();

        String reportText = "Отписались: " + report[2] +
                "\nЗаписались: " + report[1] +
                "\nНе записаны: " + report[0];

        ArrayList<String> reportList = new ArrayList<>();
        reportList.add(reportText);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, reportList);
        listView.setAdapter(adapter);
    }

    public void onBackButtonClicked(View view) {
        finish();
    }
}


