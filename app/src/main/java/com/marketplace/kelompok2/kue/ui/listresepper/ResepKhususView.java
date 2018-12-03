package com.marketplace.kelompok2.kue.ui.listresepper;

import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.Resep;

import java.util.ArrayList;

public interface ResepKhususView extends BaseView{
    void showListResep(ArrayList<Resep> listResep);
}
