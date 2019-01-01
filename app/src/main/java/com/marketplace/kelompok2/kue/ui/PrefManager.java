package com.marketplace.kelompok2.kue.ui;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.marketplace.kelompok2.kue.model.Pembeli;

public class PrefManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREF_NAME = "kue-pembeli";
    private static final String USER_ID = "user-id";
    private static final String OBJ_PEMBELI = "pembeli-obj";

    private int PRIVATE_MODE = 0;

    public PrefManager(Context context){
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        this.context = context;
    }

    public void setUser(Integer idUser, Pembeli pembeli){
        editor.putInt(USER_ID, idUser);
        Gson gson = new Gson();
        String json = gson.toJson(pembeli);
        editor.putString(OBJ_PEMBELI, json);
        editor.commit();
    }

    public Integer getUserId(){
        return pref.getInt(USER_ID,0);
    }

    public Pembeli getObjPembeli(){
        Gson gson = new Gson();
        String json = pref.getString(OBJ_PEMBELI, "");
        Pembeli pembeli = gson.fromJson(json, Pembeli.class);
        return pembeli;
    }
}
