package com.example.examtest;

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


    private ArrayList<Patient> list;

    private DbList() {
        list = new ArrayList<Patient>();
        list.add(new Patient("ivan1", 10));
        list.add(new Patient("ivan2", 12));
        list.add(new Patient("ivan3", 14));
        list.add(new Patient("ivan4", 16));
        list.add(new Patient("ivan5", 18));
        list.add(new Patient("ivan6", 20));
    }

    public List<String> getAllNames() {
        return list.stream().map(pat -> pat.name).collect(Collectors.toList());
    }

    public boolean addPatient(Patient pat) {
        int newId = 0;
        for (Patient p : list)
            if (Objects.equals(p.name, pat.name)) {
                return false;
            }
        list.add(pat);
        return true;
    }

    public void removePatient(String name) {
        for (Patient p : list)
            if (Objects.equals(p.name, name)) {
                list.remove(p);
            }
    }

    Patient getByName(String name) {
        for (Patient p : list)
            if (Objects.equals(p.name, name))
                return p;
        return null;
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
}
