package com.example.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ItemAdapter;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.entity.Item;
import com.example.myapplication.fragments.ItemFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Button reportButton;
    private ItemAdapter itemAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        reportButton = findViewById(R.id.reportButton);
        databaseHelper = new DatabaseHelper(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshList();

        fab.setOnClickListener(view -> {
            // Open Add/Edit Fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            ItemFragment itemFragment = ItemFragment.newInstance(null);
            itemFragment.show(fragmentManager, "ItemFragment");
        });

        reportButton.setOnClickListener(view -> {
            // Open Report Activity
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        });

        Configuration config = getResources().getConfiguration();
        config.setLocale(new Locale("ru"));
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());


    }

    public void exportData(View view) {
        // Get all items from SQLite database
        List<Item> itemList = databaseHelper.getAllItems();

        // Convert List<Item> to JSON string
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(itemList);

        try {
            FileOutputStream fos = openFileOutput("data.json", Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
            showToast("Data exported successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            showToast("Error exporting data.");
        }
    }

    public void importData(View view) {
        try {
            FileInputStream fis = openFileInput("data.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            fis.close();

            // Convert JSON string to List<Item>
            Gson gson = new Gson();
            Type type = new TypeToken<List<Item>>() {}.getType();
            List<Item> itemList = gson.fromJson(sb.toString(), type);

            // Add items to SQLite database
            for (Item item : itemList) {
                databaseHelper.addItem(item.getName());
            }

            showToast("Data imported successfully.");
            refreshList();
        } catch (IOException e) {
            e.printStackTrace();
            showToast("Error importing data.");
        }
    }

    public void refreshList() {
        List<Item> itemList = databaseHelper.getAllItems();

        List<Item> filteredItemList = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getStatus() != 2) {
                filteredItemList.add(item);
            }
        }

        itemAdapter = new ItemAdapter(filteredItemList, databaseHelper);
        recyclerView.setAdapter(itemAdapter);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

