package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.ui.View;

import java.util.ArrayList;

public interface HomeView extends View {
    void showItems(ArrayList<Barang> listBarang);
    void showErrorMessage();
}
