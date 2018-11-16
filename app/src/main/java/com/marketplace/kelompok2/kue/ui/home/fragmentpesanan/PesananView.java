package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.BarangTransaksi;
import com.marketplace.kelompok2.kue.model.Pesanan;
import com.marketplace.kelompok2.kue.base.BaseView;

import java.util.ArrayList;

public interface PesananView extends BaseView{
    void showListPesanan(ArrayList<BarangTransaksi> listPesanan);
}
