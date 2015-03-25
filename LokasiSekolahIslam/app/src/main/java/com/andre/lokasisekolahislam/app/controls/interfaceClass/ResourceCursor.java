package com.andre.lokasisekolahislam.app.controls.interfaceClass;

import android.database.Cursor;

/**
 * Created by Andre on 3/17/2015.
 */
public interface ResourceCursor {
    Cursor cursor = null;
    public void setCursor(Cursor cursor);

    public double cursosDouble(String field);

    public String cursorString(String field);

    public int cursorInt(String field);
}
