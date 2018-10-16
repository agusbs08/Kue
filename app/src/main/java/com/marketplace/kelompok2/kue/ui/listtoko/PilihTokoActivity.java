package com.marketplace.kelompok2.kue.ui.listtoko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Penjual;

import java.util.ArrayList;


public class PilihTokoActivity extends AppCompatActivity implements PilihTokoView{

    private ArrayList<Penjual> listPenjual;
    private RecyclerView recyclerView;
    private PilihTokoRecyclerViewAdapter adapter;
    private PilihTokoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihtoko);
        initView();
        initComponent();
        presenter.getListToko();
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_pilihtoko);
    }

    private void initComponent(){
        listPenjual = new ArrayList<>();
        adapter = new PilihTokoRecyclerViewAdapter(this, listPenjual);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter = new PilihTokoPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showListKeranjang(ArrayList<Penjual> listPenjual){
        this.listPenjual.clear();
        this.listPenjual.addAll(listPenjual);
        adapter.notifyDataSetChanged();
    }
}
