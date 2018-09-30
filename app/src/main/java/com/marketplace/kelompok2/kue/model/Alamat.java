package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Alamat {
    @SerializedName("id_alamat_pengiriman")
    private Integer id;

    @SerializedName("pembeli")
    private Pembeli pembeli;

    @SerializedName("alamat_lengkap")
    private String alamatLengkap;

    @SerializedName("kab")
    private String kota;

    @SerializedName("kec")
    private String kecamatan;

    @SerializedName("provinsi")
    private String provinsi;

    @SerializedName("kode_pos")
    private String kodePos;

    public Alamat(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }
}
