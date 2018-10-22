package com.marketplace.kelompok2.kue.ui.listtoko;

import com.marketplace.kelompok2.kue.model.BarangTokoList;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.base.BaseView;

import java.util.ArrayList;

public interface PilihTokoView extends BaseView {
    void showListKeranjang(ArrayList<BarangTokoList> listBarangPenjual);
}
