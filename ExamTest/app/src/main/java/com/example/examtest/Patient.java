package com.example.examtest;

public class Patient {
    int id;
    String name;
    int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
