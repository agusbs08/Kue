package com.marketplace.kelompok2.kue.model.list;

import com.google.gson.annotations.SerializedName;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.ResepFavorit;

import java.util.ArrayList;

public class ResepList {
    @SerializedName("pembeli")
    private Pembeli pembeli;

    @SerializedName("list_resep")
    private ArrayList<ResepFavorit> listResepFavorit;

    public ResepList(){

    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public ArrayList<ResepFavorit> getListResep() {
        return listResepFavorit;
    }

    public void setListResep(ArrayList<ResepFavorit> listResepFavorit) {
        this.listResepFavorit = listResepFavorit;
    }
}
