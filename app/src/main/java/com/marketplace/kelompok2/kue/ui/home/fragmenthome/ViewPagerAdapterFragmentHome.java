package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.fragmentberanda.BerandaFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.fragmentpopuler.PopulerFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.fragmentpromo.PromoFragment;

public class ViewPagerAdapterFragmentHome extends FragmentPagerAdapter {

    private final Integer PAGE_COUNT = 3;
    private final Context context;
    public ViewPagerAdapterFragmentHome(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new BerandaFragment();
                break;
            case 1:
                fragment = new PopulerFragment();
                break;
            case 2:
                fragment = new PromoFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getResources().getString(R.string.tab_beranda_home);
            case 1:
                return context.getResources().getString(R.string.tab_popular_home);
            case 2:
                return context.getResources().getString(R.string.tab_promo_home);
        }
        return null;
    }
}
