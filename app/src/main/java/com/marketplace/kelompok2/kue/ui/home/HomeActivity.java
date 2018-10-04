package com.marketplace.kelompok2.kue.ui.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.HomeFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang.KeranjangFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentprofile.ProfileFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmenttransaksi.TransaksiFragment;
import com.marketplace.kelompok2.kue.ui.home.fragmentwishlist.WishlistFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView btn = (BottomNavigationView)findViewById(R.id.bottom_navigation_menu);
        btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu :
                        loadHomeFragment(savedInstanceState);
                        break;
                    case R.id.keranjang_menu :
                        loadKeranjangFragment(savedInstanceState);
                        break;
                    case R.id.wishlist_menu :
                        loadWishlistFragment(savedInstanceState) ;
                        break;
                    case R.id.traksaksi_menu :
                        loadTransaksiFragment(savedInstanceState);
                        break;
                    case R.id.profile_menu :
                        loadProfileFragment(savedInstanceState);
                        break;
                }
                return true;
            }
        });
    }

    private void loadHomeFragment(Bundle savedInstanceState){
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new HomeFragment(), "Home")
                    .commit();
        }
    }

    private void loadKeranjangFragment(Bundle savedInstanceState){
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new KeranjangFragment(), "Home")
                    .commit();
        }
    }

    private void loadWishlistFragment(Bundle savedInstanceState){
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new WishlistFragment(), "Home")
                    .commit();
        }
    }

    private void loadTransaksiFragment(Bundle savedInstanceState){
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new TransaksiFragment(), "Home")
                    .commit();
        }
    }

    private void loadProfileFragment(Bundle savedInstanceState){
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new ProfileFragment(), "Home")
                    .commit();
        }
    }
}
