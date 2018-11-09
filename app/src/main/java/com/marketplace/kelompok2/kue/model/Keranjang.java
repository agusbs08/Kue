package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Keranjang implements Serializable{
    @SerializedName("id_keranjang")
    private Integer id;

    @SerializedName("total_harga_keranjang")
    private Float totalHarga;

    @SerializedName("id_pembeli")
    private Integer id_pembeli;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updateAt;

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

    public Integer getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(Integer id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
