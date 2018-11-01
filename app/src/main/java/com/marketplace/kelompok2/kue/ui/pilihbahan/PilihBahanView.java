package com.marketplace.kelompok2.kue.ui.pilihbahan;

import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.BarangTokoList;

import java.util.ArrayList;

public interface PilihBahanView extends BaseView{
    void showListBahan(ArrayList<BarangTokoList> listBarang);
}
