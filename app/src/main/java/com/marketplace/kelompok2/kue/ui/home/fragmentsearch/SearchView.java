package com.marketplace.kelompok2.kue.ui.home.fragmentsearch;

import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.base.BaseView;

import java.util.ArrayList;

public interface SearchView extends BaseView{
    void showListSearch(ArrayList<Resep> reseps, String keyword);
}
