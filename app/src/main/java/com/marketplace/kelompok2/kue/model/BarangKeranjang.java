package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BarangKeranjang implements Serializable{
    @SerializedName("barang")
    private Barang barang;

    @SerializedName("id_isi_keranjang")
    private Integer idIsiKeranjang;

    @SerializedName("quantity_barang")
    private Integer kuantitas;

    public BarangKeranjang(){

    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getIdIsiKeranjang() {
        return idIsiKeranjang;
    }

    public void setIdIsiKeranjang(Integer idIsiKeranjang) {
        this.idIsiKeranjang = idIsiKeranjang;
    }

    public Integer getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        this.kuantitas = kuantitas;
    }
}
