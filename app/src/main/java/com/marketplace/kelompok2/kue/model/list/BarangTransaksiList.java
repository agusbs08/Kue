package com.marketplace.kelompok2.kue.model.list;

import com.google.gson.annotations.SerializedName;
import com.marketplace.kelompok2.kue.model.BarangTransaksi;
import com.marketplace.kelompok2.kue.model.Pembeli;

import java.util.ArrayList;

public class BarangTransaksiList {
    @SerializedName("pembeli")
    private Pembeli pembeli;

    @SerializedName("list_barang")
    private ArrayList<BarangTransaksi> listBarang;

    public BarangTransaksiList(){

    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public ArrayList<BarangTransaksi> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<BarangTransaksi> listBarang) {
        this.listBarang = listBarang;
    }
}
