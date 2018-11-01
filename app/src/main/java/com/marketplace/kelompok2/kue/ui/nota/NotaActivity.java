package com.marketplace.kelompok2.kue.ui.nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    private TextView namaToko;
    private TextView totalHarga;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_pesanan);
        initData();
        initView();
    }

    private void initData(){
        Intent intent = getIntent();
        listBarang = (BarangList) intent.getSerializableExtra("listBarang");
        penjual = (Penjual) intent.getSerializableExtra("penjual");
    }

    private void initView(){
        namaToko = findViewById(R.id.tv_namatoko_nota);
        recyclerView = findViewById(R.id.rv_listbarang_nota);
        totalHarga = findViewById(R.id.tv_totalharga);
        progressBar = findViewById(R.id.pb_daftar_pesanan);
        adapter = new NotaRecyclerViewAdapter(listBarang);
        namaToko.setText(penjual.getNamatoko());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        initTotalHarga();
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void initTotalHarga(){
        Float total = new Float(0);
        for(Barang barang : listBarang.getListBarang()){
            total += barang.getHarga();
        }
        totalHarga.setText(total.toString());
    }
}
