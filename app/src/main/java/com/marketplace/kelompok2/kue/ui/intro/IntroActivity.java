package com.marketplace.kelompok2.kue.ui.intro;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                intent.putExtra("state", 0);
                startActivity(intent);
                finish();
            }
        }, 1500L);
    }
}
