package com.marketplace.kelompok2.kue.model.list;

import com.google.gson.annotations.SerializedName;

import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.Keranjang;
import com.marketplace.kelompok2.kue.model.Penjual;

import java.io.Serializable;
import java.util.ArrayList;

public class KeranjangList implements Serializable{
    @SerializedName("id_penjual")
    private Integer idPenjual;

    @SerializedName("penjual")
    private Penjual penjual;

    @SerializedName("list_barang")
    private ArrayList<BarangKeranjang> listBarang;

    public Integer getIdPenjual() {
        return idPenjual;
    }

    public void setIdPenjual(Integer idPenjual) {
        this.idPenjual = idPenjual;
    }

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }

    public ArrayList<BarangKeranjang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<BarangKeranjang> listBarang) {
        this.listBarang = listBarang;
    }
}
