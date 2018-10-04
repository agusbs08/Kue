package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class IsiKeranjang {

    @SerializedName("id")
    private Integer id;

    @SerializedName("barang")
    private Barang barang;

    @SerializedName("keranjang")
    private Keranjang keranjang;
}
