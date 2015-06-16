package com.andre.lokasisekolahislam.app.controls.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Andre on 6/16/2015.
 */
public class SessionApp {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionApp(Context context){
        sharedPreferences = context.getSharedPreferences("sesi",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.commit();
    }

    public void setSession(String a){
        editor.putString("sesi",a);
        editor.commit();
    }

    public String getSession(){
        return sharedPreferences.getString("sesi",null);
    }

    public void clearSession(){
        editor.clear();
        editor.commit();
    }
}
