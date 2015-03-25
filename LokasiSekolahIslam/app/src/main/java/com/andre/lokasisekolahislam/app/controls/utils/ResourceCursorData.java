package com.andre.lokasisekolahislam.app.controls.utils;

import android.database.Cursor;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.ResourceCursor;

/**
 * Created by Andre on 3/17/2015.
 */
public class ResourceCursorData implements ResourceCursor {
    private Cursor cursor;
    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public double cursosDouble(String field) {
        return cursor.getDouble(fieldCursor(field));
    }

    @Override
    public String cursorString(String field) {
        return cursor.getString(fieldCursor(field));
    }

    @Override
    public int cursorInt(String field) {
        return cursor.getInt(fieldCursor(field));
    }
    private int fieldCursor(String field){
        return cursor.getColumnIndex(field);
    }
}
