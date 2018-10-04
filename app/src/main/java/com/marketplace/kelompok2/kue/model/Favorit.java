package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Favorit {
    @SerializedName("id")
    private Integer id;

    @SerializedName("pembeli")
    private Pembeli pembeli;

    @SerializedName("penjual")
    private Penjual penjual;
}
