package com.marketplace.kelompok2.kue.ui.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.Common;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.HomeFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang.KeranjangFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentpesanan.PesananFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentprofile.ProfileFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentsearch.SearchFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentwishlist.WishlistFragment;
import com.marketplace.kelompok2.kue.util.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity implements HomeSearchView{

    private Bundle save;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        save = savedInstanceState;
        BottomNavigationView btn = findViewById(R.id.bottom_navigation_menu);
        BottomNavigationViewHelper.disableShiftMode(btn);
        btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu :
                        setFragment(savedInstanceState, new HomeFragment());
                        break;
                    case R.id.keranjang_menu :
                        setFragment(savedInstanceState, new KeranjangFragment());
                        break;
                    case R.id.wishlist_menu :
                        setFragment(savedInstanceState, new WishlistFragment());
                        break;
                    case R.id.traksaksi_menu :
                        setFragment(savedInstanceState, new PesananFragment());
                        break;
                    case R.id.profile_menu :
                        setFragment(savedInstanceState, new ProfileFragment());
                        break;
                }
                return true;
            }
        });
        btn.setSelectedItemId(R.id.home_menu);
    }

    private void setFragment(Bundle savedInstanceState, Fragment fragment){
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment, "Home")
                    .commit();
        }
    }

    @Override
    public void setSearchFragment(){
        if(save == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new SearchFragment(), "Search")
                    .addToBackStack("tag")
                    .commit();
        }
    }
}
