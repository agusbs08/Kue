package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Notifikasi implements Serializable{
    @SerializedName("id")
    private Integer id;

    @SerializedName("pembeli")
    private Pembeli pembeli;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("tanggal_notif")
    private String tanggalNotif;
}
