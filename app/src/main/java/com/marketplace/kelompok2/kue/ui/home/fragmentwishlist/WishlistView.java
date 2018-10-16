package com.marketplace.kelompok2.kue.ui.home.fragmentwishlist;

import com.marketplace.kelompok2.kue.model.Favorit;
import com.marketplace.kelompok2.kue.base.BaseView;

import java.util.ArrayList;

public interface WishlistView extends BaseView{
    void showListWishlist(ArrayList<Favorit> listFavorit);
}
