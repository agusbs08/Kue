package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Keranjang implements Serializable{
    @SerializedName("id_keranjang")
    private Integer id;

    @SerializedName("total_harga")
    private Float totalHarga;

    @SerializedName("pembeli")
    private Pembeli pembeli;

    public Keranjang(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Float totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }
}
