package com.andre.lokasisekolahislam.app.controls.dbGetData;

import android.content.Context;
import com.andre.lokasisekolahislam.app.controls.dao.DaoRaudhatulAtfal;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.models.BaseModel;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class AllData {
    private final Context context;
    private final DbHelper dbHelper;
    private BaseAllDataOther baseAllDataOther;

    public AllData(Context context, DbHelper dbHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
    }

    public ArrayList<BaseModel> allDataMadrasahAliyah(){
        baseAllDataOther = new BaseAllDataOther(context,dbHelper);
        return baseAllDataOther.getAllData(dbHelper.tableMadrasahAliyah);
    }
    public ArrayList<BaseModel> allDataMadrasahDiniyahTakmiliya(){
        baseAllDataOther = new BaseAllDataOther(context,dbHelper);
        return baseAllDataOther.getAllData(dbHelper.tableMadrasahDiniyahTakmiliya);
    }
    public ArrayList<BaseModel> allDataMadrasahIbtidaiyah(){
        baseAllDataOther = new BaseAllDataOther(context,dbHelper);
        return baseAllDataOther.getAllData(dbHelper.tableMAdrasahIbtidaiyah);
    }
    public ArrayList<BaseModel> allDataPerguruanTinggiAgamaIslam(){
        baseAllDataOther = new BaseAllDataOther(context,dbHelper);
        return baseAllDataOther.getAllData(dbHelper.tablePerguruanTinggiAgamaIslam);
    }
    public ArrayList<BaseModel> allDataPondokPesantren(){
        baseAllDataOther = new BaseAllDataOther(context,dbHelper);
        return baseAllDataOther.getAllData(dbHelper.tablePondokPesantren);
    }
    public ArrayList<BaseModel> allDataRaudathulAtfal(){
        DaoRaudhatulAtfal daoRaudhatulAtfal = new DaoRaudhatulAtfal(dbHelper,context);
        daoRaudhatulAtfal = new DaoRaudhatulAtfal(dbHelper,context);
        try {
            return daoRaudhatulAtfal.getAll(dbHelper.tableRaudathulAtfal,daoRaudhatulAtfal.allColumns);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            daoRaudhatulAtfal.close();
        }
        return null;
    }
}
