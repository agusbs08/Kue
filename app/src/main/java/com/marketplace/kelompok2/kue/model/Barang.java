package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Barang {
    @SerializedName("id_barang")
    private Integer id;

    @SerializedName("nama_barang")
    private String nama;

    @SerializedName("merk_barang")
    private String merk;

    @SerializedName("image_barang")
    private String gambar;

    @SerializedName("kategori")
    private Kategori kategori;

    @SerializedName("rating")
    private Float rating;

    @SerializedName("stok_barang")
    private Float stok;

    @SerializedName("jumlah_terjual")
    private Integer jumlahTerjual;

    @SerializedName("potongan_harga")
    private Float potonganHarga;

    @SerializedName("harga_barang")
    private Float harga;


    public Barang(){

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

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Float getStok() {
        return stok;
    }

    public void setStok(Float stok) {
        this.stok = stok;
    }

    public Integer getJumlahTerjual() {
        return jumlahTerjual;
    }

    public void setJumlahTerjual(Integer jumlahTerjual) {
        this.jumlahTerjual = jumlahTerjual;
    }

    public Float getPotonganHarga() {
        return potonganHarga;
    }

    public void setPotonganHarga(Float potonganHarga) {
        this.potonganHarga = potonganHarga;
    }

    public Float getHarga() {
        return harga;
    }

    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
