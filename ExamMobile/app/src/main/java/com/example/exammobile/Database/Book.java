package com.example.exammobile.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "books")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String author;
    private String izdName;
    private String izdDate;

    public Book(String name, String author, String izdName, String izdDate) {
        this.name = name;
        this.author = author;
        this.izdName = izdName;
        this.izdDate = izdDate;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIzdName() {
        return izdName;
    }

    public void setIzdName(String izdName) {
        this.izdName = izdName;
    }

    public String getIzdDate() {
        return izdDate;
    }

    public void setIzdDate(String izdDate) {
        this.izdDate = izdDate;
    }
}