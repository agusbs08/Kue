package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BarangTokoList {
    @SerializedName("barang")
    private ArrayList<Barang> listBarang;

    @SerializedName("penjual")
    private Penjual penjual;

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
}