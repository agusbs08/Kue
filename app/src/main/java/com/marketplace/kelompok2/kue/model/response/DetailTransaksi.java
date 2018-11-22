package com.marketplace.kelompok2.kue.model.response;

import com.google.gson.annotations.SerializedName;
import com.marketplace.kelompok2.kue.model.Penjual;

import java.util.Date;

public class DetailTransaksi {
    @SerializedName("id_detail_transaksi")
    private Integer id;

    @SerializedName("id_konfirmasi")
    private Integer idKonfirmasi;

    @SerializedName("created_at")
    private String createdAt;

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

    @SerializedName("metode_pembayaran")
    private String metodePembayaran;

    @SerializedName("id_penjual")
    private Integer idPenjual;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKonfirmasi() {
        return idKonfirmasi;
    }

    public void setIdKonfirmasi(Integer idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Integer getIdPenjual() {
        return idPenjual;
    }

    public void setIdPenjual(Integer idPenjual) {
        this.idPenjual = idPenjual;
    }
}
