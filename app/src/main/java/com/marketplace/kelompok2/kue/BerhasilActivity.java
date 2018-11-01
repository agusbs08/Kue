package com.marketplace.kelompok2.kue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.marketplace.kelompok2.kue.model.response.DataResponse;

import java.util.ArrayList;

public class BerhasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil);
        initData();
    }

    private void initData(){
        Intent intent = getIntent();
        BarangList listBarang = (BarangList) intent.getSerializableExtra("listBarang");
        for(int i=0;i<listBarang.getListBarang().size();i++){
            Toast.makeText(this, listBarang.getListBarang().get(i).getNama(), Toast.LENGTH_SHORT).show();
        }
    }
}
