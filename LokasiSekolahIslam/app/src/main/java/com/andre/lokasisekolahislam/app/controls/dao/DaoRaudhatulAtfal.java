package com.andre.lokasisekolahislam.app.controls.dao;

import android.content.Context;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.models.BaseModel;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class DaoRaudhatulAtfal extends BaseDao<BaseModel> {


    public String[] allColumns = columns.columnsRaudathul;
    public DaoRaudhatulAtfal(DbHelper helper, Context context) {
        super(helper, context);
    }

    @Override
    public BaseModel cursorData() {
        BaseModel modelRaudathulAtfal = new BaseModel();
        modelRaudathulAtfal.setLatitude(resourceCursorData.cursosDouble(helper.latitude));
        modelRaudathulAtfal.setLongitude(resourceCursorData.cursosDouble(helper.longitude));
        modelRaudathulAtfal.setJenis(resourceCursorData.cursorString(helper.jenis));
        modelRaudathulAtfal.setId(resourceCursorData.cursorString(helper.id));
        modelRaudathulAtfal.setNamaInstitusi(resourceCursorData.cursorString(helper.judul));
        modelRaudathulAtfal.setAlamat(resourceCursorData.cursorString(helper.deskripsi));
        modelRaudathulAtfal.setIdField(resourceCursorData.cursorInt(helper.idField));
        return modelRaudathulAtfal;
    }

    @Override
    public ArrayList<BaseModel> getAll(String tableName, String[] allColumns) {
        return super.getAll(tableName, allColumns);
    }
}
