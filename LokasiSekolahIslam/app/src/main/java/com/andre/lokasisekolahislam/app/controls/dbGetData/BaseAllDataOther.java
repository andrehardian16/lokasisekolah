package com.andre.lokasisekolahislam.app.controls.dbGetData;

import android.content.Context;
import com.andre.lokasisekolahislam.app.controls.dao.DaoOther;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.models.BaseModel;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class BaseAllDataOther {
    private final Context context;
    private final DbHelper dbHelper;
    private DaoOther daoOther;

    public BaseAllDataOther(Context context, DbHelper dbHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
    }
    public ArrayList<BaseModel> getAllData(String tableName){
        daoOther = new DaoOther(dbHelper,context);
        try {
            return daoOther.getAll(tableName,daoOther.allColumns);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            daoOther.close();
        }
        return null;
    }

}
