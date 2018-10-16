package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.Resep;

import java.util.ArrayList;

public interface HomeView extends BaseView {
    void showListResep(ArrayList<Resep> listResep);
    void showErrorMessage();
}
