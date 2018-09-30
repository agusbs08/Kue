package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Kategori {
    @SerializedName("id_kategori")
    private Integer id;

    @SerializedName("nama_kategori")
    private String nama;

    public Kategori(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
