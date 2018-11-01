package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Penjual implements Serializable {
    @SerializedName("id_penjual")
    private Integer id;

    @SerializedName("username_pen")
    private String username;

    @SerializedName("password_pen")
    private String password;

    @SerializedName("alamat_pen")
    private String alamat;

    @SerializedName("email_pen")
    private String email;

    @SerializedName("notlp_pen")
    private Integer noTelepon;

    @SerializedName("nama_pen")
    private String nama;

    @SerializedName("jenis_kelamin_pen")
    private String jenisKelamin;

    @SerializedName("nama_toko_pen")
    private String namatoko;

    @SerializedName("image_pen")
    private String imagePenjual;

    public Penjual(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(Integer noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamatoko() {
        return namatoko;
    }

    public void setNamatoko(String namatoko) {
        this.namatoko = namatoko;
    }

    public String getImagePenjual() {
        return imagePenjual;
    }

    public void setImagePenjual(String imagePenjual) {
        this.imagePenjual = imagePenjual;
    }
}
