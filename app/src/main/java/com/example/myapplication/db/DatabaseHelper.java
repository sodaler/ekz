package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.entity.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "items.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ITEMS = "items";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_FIO = "fio";
    private static final String COLUMN_STATUS = "status";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_FIO + " TEXT,"
                + COLUMN_STATUS + " INTEGER"
                + ")";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    public void addItem(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_FIO)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS))
                );
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return itemList;
    }

    public void takeItem(int id, String fio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIO, fio);
        values.put(COLUMN_STATUS, 1);

        db.update(TABLE_ITEMS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STATUS, 2);

        db.update(TABLE_ITEMS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public int[] getReport() {
        int[] report = new int[3];

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_STATUS + ", COUNT(*) FROM " + TABLE_ITEMS + " GROUP BY " + COLUMN_STATUS;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int status = cursor.getInt(0);
            int count = cursor.getInt(1);
            report[status] = count;
        }

        cursor.close();
        db.close();

        return report;
    }

    public void updateItem(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);

        db.update(TABLE_ITEMS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }
}

