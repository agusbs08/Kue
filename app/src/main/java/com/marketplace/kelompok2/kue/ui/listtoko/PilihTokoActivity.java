package com.marketplace.kelompok2.kue.ui.listtoko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangTokoList;
import com.marketplace.kelompok2.kue.model.Penjual;

import java.util.ArrayList;


public class PilihTokoActivity extends AppCompatActivity implements PilihTokoView{

    private ArrayList<BarangTokoList> listBarangPenjual;
    private RecyclerView recyclerView;
    private PilihTokoRecyclerViewAdapter adapter;
    private PilihTokoPresenter presenter;
    private String[] listBahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihtoko);
        initView();
        initComponent();
        initData();
        presenter.getListToko(setStrListBahan());
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_pilihtoko);
    }

    private void initComponent(){
        listBarangPenjual = new ArrayList<>();
        adapter = new PilihTokoRecyclerViewAdapter(this, listBarangPenjual);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter = new PilihTokoPresenter(this);
    }

    private void initData(){
        Intent intent = getIntent();
        listBahan = intent.getStringArrayExtra("listBahan");
    }

    private String setStrListBahan(){
        String str = "";
        for(int i=0;i<listBahan.length;i++){
            if(i == listBahan.length -1){
                str += listBahan[i];
            }
            else{
                str += listBahan[i] + ",";
            }
        }
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        return str;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showListKeranjang(ArrayList<BarangTokoList> listBarangPenjual){
        this.listBarangPenjual.clear();
        this.listBarangPenjual.addAll(listBarangPenjual);
        adapter.notifyDataSetChanged();
    }
}
