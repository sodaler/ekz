package com.example.myapplication.entity;

import java.io.Serializable;

public class Item implements Serializable{
    private int id;
    private String name;
    private String fio;
    private int status;

    public Item(int id, String name, String fio, int status) {
        this.id = id;
        this.name = name;
        this.fio = fio;
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

