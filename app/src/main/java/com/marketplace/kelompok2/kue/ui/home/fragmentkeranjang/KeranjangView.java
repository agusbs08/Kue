package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.Keranjang;
import com.marketplace.kelompok2.kue.base.BaseView;

import java.util.ArrayList;

public interface KeranjangView extends BaseView {
    void showListKeranjang(ArrayList<BarangKeranjang> keranjangs);
}
