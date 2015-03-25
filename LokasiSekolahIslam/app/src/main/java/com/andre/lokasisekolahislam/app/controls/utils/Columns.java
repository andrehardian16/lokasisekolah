package com.andre.lokasisekolahislam.app.controls.utils;

import android.content.Context;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;

/**
 * Created by Andre on 3/17/2015.
 */
public class Columns extends DbHelper{

    public Columns(Context context) {
        super(context);
    }
    public String[] columnsOther = {id,latitude,longitude,jenis,alamat,namaInstitusi,idField};
    public String[] columnsRaudathul = {id,latitude,longitude,jenis,deskripsi,judul,idField};
}
