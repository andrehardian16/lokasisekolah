package com.andre.lokasisekolahislam.app.controls.helperDb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.*;

/**
 * Created by Andre on 3/17/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    private final Context context;
    private final static String DB_NAME = "location.db";
    private final static int DB_VER = 1;

    //    table name
    public final static String tableMadrasahAliyah = "madrasah_aliyah";
    public final static String tableMadrasahDiniyahTakmiliya = "madrasah_diniyah_takmiliya";
    public final static String tableMAdrasahIbtidaiyah = "madrasah_ibtidaiyah";
    public final static String tablePerguruanTinggiAgamaIslam = "perguruan_tinggi_agama_islam";
    public final static String tablePondokPesantren = "pondok_pesantren";
    public final static String tableRaudathulAtfal = "raudhatul_atfal";

    /*    content of table madrasah aliyah, madrasah diniyah takmiliya, madrasah ibtidaiyah, perguruan tinggi agama
    islam raudathul atfal*/

    public final static String id = "id";
    public final static String idField = "id_field";
    public final static String latitude = "latitude";
    public final static String longitude = "longitude";
    public final static String jenis = "jenis";
    /*        content for table madrasah aliyah, madrasah diniyah takmiliya, madrasah ibtidaiyah,
    perguruan tinggi agama islam*/
    public final static String namaInstitusi = "nama_institusi";
    public final static String alamat = "alamat";

//    content for table raudhatul atfal
    public final static String judul ="judul";
    public final static String deskripsi = "deskripsi";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private boolean checkDatabase() {
        File file = context.getDatabasePath(DB_NAME);
        return file.exists() && !file.isDirectory();
    }

    public void readDatabase() {
        if (checkDatabase()) {
            try {
                InputStream inputStream = context.getAssets().open(DB_NAME);
                OutputStream outputStream = new FileOutputStream(context.getDatabasePath(DB_NAME).toString());
                try {
                    byte[] byteData = new byte[1024];
                    int pos;
                    while ((pos = inputStream.read(byteData)) > 0){
                        outputStream.write(byteData,0,byteData.length);
                    }
                } finally {
                    inputStream.close();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
