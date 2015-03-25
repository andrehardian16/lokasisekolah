package com.andre.lokasisekolahislam.app.controls.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.controls.utils.Columns;
import com.andre.lokasisekolahislam.app.controls.utils.ResourceCursorData;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class BaseDao<T> {
    protected final DbHelper helper;
    protected SQLiteDatabase database;
    protected ResourceCursorData resourceCursorData = new ResourceCursorData();
    protected Columns columns;

    public BaseDao(DbHelper helper, Context context) {
        this.helper = helper;
        columns = new Columns(context);
        try {
            helper.readDatabase();
                database = helper.getReadableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> getAll(String tableName, String[] allColumns) {
        ArrayList<T> allData = new ArrayList<T>();
        try {
            Cursor cursor = database.query(tableName, allColumns, null, null, null, null, null);
            cursor.moveToFirst();
            resourceCursorData.setCursor(cursor);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        T t  = cursorData();
                        allData.add(t);
                    }while (cursor.moveToNext());
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }

    public void close() {
        database.close();
    }

    public T cursorData() {
        return null;
    }


}
