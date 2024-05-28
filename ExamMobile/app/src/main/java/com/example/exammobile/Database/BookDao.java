package com.example.exammobile.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.exammobile.Database.Book;

@Dao
public interface BookDao {
    @Query("SELECT * FROM books")
    List<Book> getAllBooks();

    @Insert
    void insertBook(Book book);

    @Update
    void updateBook(Book book);

    @Delete
    void deleteBook(Book book);

    @Query("SELECT author, COUNT(*) as bookCount FROM books GROUP BY author")
    List<AuthorBookCount> getBookCountByAuthor();
}
