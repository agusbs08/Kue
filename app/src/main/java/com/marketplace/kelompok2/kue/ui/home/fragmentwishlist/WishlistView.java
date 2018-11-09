package com.marketplace.kelompok2.kue.ui.home.fragmentwishlist;

import com.marketplace.kelompok2.kue.model.Favorit;
import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.ResepFavorit;
import com.marketplace.kelompok2.kue.model.list.ResepList;

import java.util.ArrayList;

public interface WishlistView extends BaseView{
    void showListWishlist(ArrayList<ResepFavorit> listResepFavorit);
}
