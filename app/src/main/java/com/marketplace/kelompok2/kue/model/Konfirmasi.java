package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Konfirmasi {

    @SerializedName("id_konfirmasi")
    private Integer id;

    @SerializedName("detail_transaksi")
    private Pesanan detailPesanan;

    @SerializedName("waktu_pembayaran")
    private String waktuPembayaran;

    @SerializedName("bank")
    private String bank;

    @SerializedName("no_rek")
    private Integer nomorRekening;

    @SerializedName("image_bukti")
    private String imageBukti;

    public Konfirmasi(){

    }

}
