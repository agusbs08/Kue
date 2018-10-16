package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Pesanan {
    @SerializedName("id_detail_transaksi")
    private Integer id;

    @SerializedName("konfirmasi")
    private Konfirmasi konfirmasi;

    @SerializedName("waktu")
    private String waktu;

    @SerializedName("status_pembayaran")
    private String statusPembayaran;

    @SerializedName("status_proses")
    private String statusProses;

    @SerializedName("status_pengiriman")
    private String statusPengiriman;

    @SerializedName("status_penerimaan")
    private String statusPenerimaan;

    @SerializedName("total_harga_transaksi")
    private Integer totalHargaTransaksi;

    public Pesanan(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Konfirmasi getKonfirmasi() {
        return konfirmasi;
    }

    public void setKonfirmasi(Konfirmasi konfirmasi) {
        this.konfirmasi = konfirmasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public String getStatusProses() {
        return statusProses;
    }

    public void setStatusProses(String statusProses) {
        this.statusProses = statusProses;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public String getStatusPenerimaan() {
        return statusPenerimaan;
    }

    public void setStatusPenerimaan(String statusPenerimaan) {
        this.statusPenerimaan = statusPenerimaan;
    }

    public Integer getTotalHargaTransaksi() {
        return totalHargaTransaksi;
    }

    public void setTotalHargaTransaksi(Integer totalHargaTransaksi) {
        this.totalHargaTransaksi = totalHargaTransaksi;
    }
}
