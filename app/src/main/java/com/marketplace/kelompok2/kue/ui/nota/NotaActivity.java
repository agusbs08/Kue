package com.marketplace.kelompok2.kue.ui.nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.BerhasilActivity;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.model.list.BarangList;

import java.util.ArrayList;

public class NotaActivity extends AppCompatActivity implements NotaView{

    private BarangList listBarang;
    private Penjual penjual;
    private NotaRecyclerViewAdapter adapter;
    private NotaPresenter presenter;

    private RecyclerView recyclerView;
    private TextView totalHarga;
    private ProgressBar progressBar;
    private Button btnBayar;

    private Float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        initData();
        initView();
        hideLoading();
    }

    private void initData(){
        Intent intent = getIntent();
        listBarang = (BarangList) intent.getSerializableExtra("listBarang");
        penjual = (Penjual) intent.getSerializableExtra("penjual");
    }

    private void initView(){
        recyclerView = findViewById(R.id.recyclerview_checkout);
        totalHarga = findViewById(R.id.tv_nominal_checkout);
        progressBar = findViewById(R.id.pb_checkout);
        btnBayar = findViewById(R.id.btn_bayar_checkout);
        adapter = new NotaRecyclerViewAdapter(listBarang);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        presenter = new NotaPresenter(this);
        initTotalHarga();
        setActionBtnBayar();
    }

    private void setActionBtnBayar(){
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setTransaksi(listBarang.getListBarang(), total);
            }
        });
    }

    private void initTotalHarga(){
        Float total = new Float(0);
        for(Barang barang : listBarang.getListBarang()){
            total += barang.getHarga();
        }
        this.total = total;
        totalHarga.setText("RP " + total.toString());
    }

    @Override
    public void showActionSuccess() {
        Intent intent = new Intent(getApplicationContext(), BerhasilActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
