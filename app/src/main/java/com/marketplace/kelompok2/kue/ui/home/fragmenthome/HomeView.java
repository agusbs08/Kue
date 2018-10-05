package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.ui.base.BaseView;

import java.util.ArrayList;

public interface HomeView extends BaseView {
    void showItems(ArrayList<Barang> listBarang);
    void showErrorMessage();
}
