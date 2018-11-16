package com.marketplace.kelompok2.kue.model.list;

import com.google.gson.annotations.SerializedName;

import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.Keranjang;

import java.io.Serializable;
import java.util.ArrayList;

public class KeranjangList implements Serializable{
    @SerializedName("keranjang")
    private Keranjang keranjang;

    @SerializedName("list_barang")
    private ArrayList<BarangKeranjang> listBarang;

    public KeranjangList(){

    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public ArrayList<BarangKeranjang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<BarangKeranjang> listBarang) {
        this.listBarang = listBarang;
    }
}
