package com.example.examtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    DbList db;
    String rep;
    TextView fld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent intent = getIntent();
        String option = intent.getStringExtra("opt");
        int age = intent.getIntExtra("age", 0);

        int opt = 0;
        rep = "Patients with age ";
        switch (option) {
            case "<":
                opt = -1;
                rep += "less than ";
                break;
            case "=":
                opt = 0;
                rep += "equal to ";
                break;
            case ">":
                opt = 1;
                rep += "more than ";
                break;
        }
        rep += Integer.toString(age);
        rep += ":\n";

        db = DbList.getInstance();

        ArrayList<Patient> data = db.getByAge(opt, age);

        int i = 1;
        for (Patient p : data) {
            rep += i + ". " + p.name + ", " + p.age + "\n";
            i++;
        }

        fld = findViewById(R.id.fld_report);
        fld.setText(rep);
    }
}