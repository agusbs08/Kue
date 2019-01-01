package com.marketplace.kelompok2.kue.model.list;

import com.google.gson.annotations.SerializedName;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangTransaksi;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.model.response.DetailTransaksi;

import java.util.ArrayList;

public class BarangTransaksiList {
    @SerializedName("detail_transaksi")
    private DetailTransaksi detailTransaksi;

    @SerializedName("penjual")
    private Penjual penjual;

    @SerializedName("list_barang")
    private ArrayList<BarangTransaksi> listBarang;

    public DetailTransaksi getDetailTransaksi() {
        return detailTransaksi;
    }

    public void setDetailTransaksi(DetailTransaksi detailTransaksi) {
        this.detailTransaksi = detailTransaksi;
    }

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }

    public ArrayList<BarangTransaksi> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<BarangTransaksi> listBarang) {
        this.listBarang = listBarang;
    }
}
