package com.marketplace.kelompok2.kue.ui.home.fragmentprofile;

import android.app.Activity;

import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.base.BaseView;

public interface ProfileView extends BaseView{
    void showProfile(Pembeli pembeli);
}
