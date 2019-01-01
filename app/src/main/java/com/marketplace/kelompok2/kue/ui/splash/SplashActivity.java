package com.marketplace.kelompok2.kue.ui.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.ui.PrefManager;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.marketplace.kelompok2.kue.ui.intro.IntroActivity;
import com.marketplace.kelompok2.kue.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        checkUserState();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),IntroActivity.class);
                intent.putExtra("state", 0);
                startActivity(intent);
                finish();
            }
        }, 2000L);
    }

    private void checkUserState() {
        PrefManager pref = new PrefManager(getApplicationContext());
        if(pref.getUserId() != 0){
            UserState.getInstance().setIdUser(pref.getUserId());
            UserState.getInstance().setPembeli(pref.getObjPembeli());
        }
    }
}
