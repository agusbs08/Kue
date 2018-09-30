package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Pembeli {
    @SerializedName("id_pembeli")
    private Integer id;

    @SerializedName("username_pem")
    private String username;

    @SerializedName("password_pem")
    private String password;

    @SerializedName("email_pem")
    private String email;

    @SerializedName("nama_pem")
    private String nama;

    @SerializedName("jenis_kelamin_pem")
    private String jenisKelamin;

    @SerializedName("keranjang")
    private Keranjang keranjang;

    @SerializedName("image_pem")
    private String gambarPembeli;


    public Pembeli(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public String getGambarPembeli() {
        return gambarPembeli;
    }

    public void setGambarPembeli(String gambarPembeli) {
        this.gambarPembeli = gambarPembeli;
    }

}
