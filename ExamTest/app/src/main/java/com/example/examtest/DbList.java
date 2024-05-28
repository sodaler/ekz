package com.example.examtest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DbList {

    private static DbList instance;

    public static DbList getInstance() {
        if (instance == null) {
            instance = new DbList();
        }
        return instance;
    }


    private final ArrayList<Patient> list;

    private DbList() {
        list = new ArrayList<Patient>();
        addPatient(new Patient("ivan1", 10));
        addPatient(new Patient("ivan2", 12));
        addPatient(new Patient("ivan3", 14));
        addPatient(new Patient("ivan4", 16));
        addPatient(new Patient("ivan5", 18));
        addPatient(new Patient("ivan6", 20));
    }

    public void fillList(DbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("patients", null, null, null, null, null, null);

        if (c.moveToFirst()) {
            list.clear();
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int ageColIndex = c.getColumnIndex("age");
            do {
                list.add(new Patient(c.getInt(idColIndex), c.getString(nameColIndex), c.getInt(ageColIndex)));
            } while (c.moveToNext());
        }
        c.close();
        dbHelper.close();
    }
    public void storeList(DbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.beginTransaction();

            String quer = "REPLACE INTO patients (id, name, age) VALUES ";
            String ids = "(";
            for (Patient p : list) {
                quer += "(" + p.id + ",\"" + p.name + "\"," + p.age + "),";
                ids += p.id + ",";
            }
            quer = quer.substring(0, quer.length() - 1);
            ids = ids.substring(0, ids.length() - 1);

            db.execSQL("DELETE FROM patients WHERE id not in "+ids+")");
            db.execSQL(quer);
            db.setTransactionSuccessful();
        }
        catch (Exception ex) {
            Log.w("err", "database");
        }
        finally {
            db.endTransaction();
        }
        dbHelper.close();
    }

    public List<String> getAllNames() {
        return list.stream().map(pat -> pat.name).collect(Collectors.toList());
    }

    public boolean addPatient(Patient pat) {
        int newId = 0;
        for (Patient p : list) {
            if (p.id > newId) newId = p.id;
            if (Objects.equals(p.name, pat.name)) {
                return false;
            }
        }
        pat.id = newId + 1;
        list.add(pat);
        return true;
    }

    public void removePatient(String name) {
        synchronized (list) {
            for (Patient p : list)
                if (Objects.equals(p.name, name)) {
                    list.remove(p);
                    return;
                }
        }
    }

    Patient getByName(String name) {
        for (Patient p : list)
            if (Objects.equals(p.name, name))
                return p;
        return null;
    }

    public void clearAll() {
        list.clear();
    }

    ArrayList<Patient> getByAge(int opt, int age) {
        ArrayList<Patient> lst = new ArrayList<>();
        if (opt == -1)
            for (Patient p : list)
                if (p.age < age) lst.add(p);
        if (opt == 0)
            for (Patient p : list)
                if (p.age == age) lst.add(p);
        if (opt == 1)
            for (Patient p : list)
                if (p.age > age) lst.add(p);
        return lst;
    }

    ArrayList<Patient> getAll() {
        return list;
    }
}
