package com.marketplace.kelompok2.kue.ui.listresepper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Resep;

import java.util.ArrayList;

public class ResepKhususActivity extends AppCompatActivity implements ResepKhususView{

    private ProgressBar pb;
    private TextView tvKey;
    private RecyclerView recyclerView;
    private ResepKhususRecyclerViewAdapter adapter;
    private int key, id;
    private String keyName;

    private ArrayList<Resep> listResep;
    private ResepKhususPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_beranda);
        initView();
        initData();
        hideLoading();
        if(key == 0){
            tvKey.setText("Kategori : " + keyName);
            presenter.getListResepKategori(id);
        }
        else{
            tvKey.setText("Chef : " + keyName);
            presenter.getListResepChef(id);
        }
    }

    private void initView(){
        tvKey = findViewById(R.id.tv_keylist);
        recyclerView = findViewById(R.id.recyclerView);
        pb = findViewById(R.id.pb_fragment_beranda);
        listResep = new ArrayList<>();
        adapter = new ResepKhususRecyclerViewAdapter(listResep, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        presenter = new ResepKhususPresenter(this);
    }

    private void initData(){
        Intent intent = getIntent();
        key = intent.getIntExtra("key",0);
        id = intent.getIntExtra("id", 0);
        keyName = intent.getStringExtra("name");
    }

    @Override
    public void showListResep(ArrayList<Resep> listResep) {
        this.listResep.clear();
        this.listResep.addAll(listResep);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }
}
