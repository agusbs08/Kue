package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class BarangTransaksi {
    @SerializedName("barang")
    private Barang barang;

    @SerializedName("id_transaksi")
    private Integer idTransaksi;

    @SerializedName("quantity")
    private Integer kuantitas;

    public BarangTransaksi(){

    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Integer getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        this.kuantitas = kuantitas;
    }
}
