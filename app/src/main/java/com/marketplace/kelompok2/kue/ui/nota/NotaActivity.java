package com.marketplace.kelompok2.kue.ui.nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.model.list.BarangList;

import java.util.ArrayList;

public class NotaActivity extends AppCompatActivity {

    private BarangList listBarang;
    private Penjual penjual;
    private NotaRecyclerViewAdapter adapter;

    private RecyclerView recyclerView;
    private TextView totalHarga;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        initData();
        initView();
    }

    private void initData(){
        Intent intent = getIntent();
        listBarang = (BarangList) intent.getSerializableExtra("listBarang");
        penjual = (Penjual) intent.getSerializableExtra("penjual");
    }

    private void initView(){
        recyclerView = findViewById(R.id.recyclerview_checkout);
        totalHarga = findViewById(R.id.tv_nominal_checkout);
        adapter = new NotaRecyclerViewAdapter(listBarang, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        initTotalHarga();
        //progressBar.setVisibility(View.INVISIBLE);
    }

    private void initTotalHarga(){
        Float total = new Float(0);
        for(Barang barang : listBarang.getListBarang()){
            total += barang.getHarga();
        }
        totalHarga.setText("RP " + total.toString());
    }
}
