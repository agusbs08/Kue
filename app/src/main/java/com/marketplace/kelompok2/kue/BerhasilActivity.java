package com.marketplace.kelompok2.kue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;

import java.util.ArrayList;

public class BerhasilActivity extends AppCompatActivity {

    private Button btnBacktoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes);
        initView();
        initActionBtn();
    }

    private void initView(){
        btnBacktoHome = findViewById(R.id.btn_backtohome_success);
    }

    private void initActionBtn(){
        btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                intent.putExtra("state", 0);
                finish();
            }
        });
    }
}
