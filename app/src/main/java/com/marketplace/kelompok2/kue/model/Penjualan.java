package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Penjualan {
    @SerializedName("id")
    private Integer id;

    @SerializedName("penjual")
    private Penjual penjual;

    @SerializedName("barang")
    private Barang barang;
}
