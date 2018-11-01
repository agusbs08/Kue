package com.marketplace.kelompok2.kue.model.list;

import com.marketplace.kelompok2.kue.model.Barang;

import java.io.Serializable;
import java.util.ArrayList;

public class BarangList implements Serializable{
    private ArrayList<Barang> listBarang;
    public BarangList(ArrayList<Barang> listBarang){
        this.listBarang = listBarang;
    }

    public ArrayList<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }
}
