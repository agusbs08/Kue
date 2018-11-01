package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class BarangTokoList implements Serializable {
    @SerializedName("penjual")
    private Penjual penjual;

    @SerializedName("barang")
    private ArrayList<Barang> listBarang;

    @SerializedName("keywords")
    private ArrayList<String> keywords;

    @SerializedName("batas")
    private ArrayList<Integer> batas;

    public ArrayList<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ArrayList<Integer> getBatas() {
        return batas;
    }

    public void setBatas(ArrayList<Integer> batas) {
        this.batas = batas;
    }
}