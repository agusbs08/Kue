package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Favorit implements Serializable {
    @SerializedName("id")
    private Integer id;

    @SerializedName("pembeli")
    private Pembeli pembeli;

    @SerializedName("penjual")
    private Penjual penjual;
}
