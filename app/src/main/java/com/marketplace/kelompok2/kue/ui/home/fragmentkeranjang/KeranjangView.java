package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;
import com.marketplace.kelompok2.kue.model.response.KeranjangResponse;

import java.util.ArrayList;

public interface KeranjangView extends BaseView {
    void showListKeranjang(KeranjangResponse keranjangResponse);
}
