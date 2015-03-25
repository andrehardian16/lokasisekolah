package com.andre.lokasisekolahislam.app.controls.dao;

import android.content.Context;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.models.BaseModel;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class DaoOther extends BaseDao<BaseModel> {

    public String[] allColumns = columns.columnsOther;
    public DaoOther(DbHelper helper, Context context) {
        super(helper, context);
    }

    @Override
    public BaseModel cursorData() {
        BaseModel baseModel = new BaseModel();
        baseModel.setId(resourceCursorData.cursorString(helper.id));
        baseModel.setAlamat(resourceCursorData.cursorString(helper.alamat));
        baseModel.setJenis(resourceCursorData.cursorString(helper.jenis));
        baseModel.setLongitude(resourceCursorData.cursosDouble(helper.longitude));
        baseModel.setLatitude(resourceCursorData.cursosDouble(helper.latitude));
        baseModel.setNamaInstitusi(resourceCursorData.cursorString(helper.namaInstitusi));
        baseModel.setIdField(resourceCursorData.cursorInt(helper.idField));
        return baseModel;
    }

    @Override
    public ArrayList<BaseModel> getAll(String tableName, String[] allColumns) {
        return super.getAll(tableName, allColumns);
    }
}
