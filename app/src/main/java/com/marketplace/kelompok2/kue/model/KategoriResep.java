package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class KategoriResep {

    @SerializedName("id_kategori_resep")
    private Integer idKategori;

    @SerializedName("nama_kategori_resep")
    private String namaKategori;

    @SerializedName("image_kategori_resep")
    private String imageKategori;

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public String getImageKategori() {
        return imageKategori;
    }

    public void setImageKategori(String imageKategori) {
        this.imageKategori = imageKategori;
    }
}
