package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.list.BarangTransaksiList;

import java.util.ArrayList;

public interface PesananView extends BaseView{
    void showListPesanan(ArrayList<BarangTransaksiList> listPesanan);
}
