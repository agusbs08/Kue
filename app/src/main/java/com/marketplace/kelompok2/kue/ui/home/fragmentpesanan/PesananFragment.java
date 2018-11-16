package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.BarangTransaksi;

import java.util.ArrayList;

/**
 * Created by ridho on 05/10/18.
 */

public class PesananFragment extends Fragment implements PesananView{

    private RecyclerView recyclerView;
    private TextView namaToko;
    private PesananBarangRecyclerViewAdapter adapter;
    private PesananPresenter presenter;
    private ArrayList<BarangTransaksi> listBarang;
    private TextView totalHarga;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getListTransaksi(UserState.getInstance().getIdUser());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.daftar_pesanan, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view){
        listBarang = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rv_listbarang_nota);
        namaToko = view.findViewById(R.id.tv_namatoko_nota);
        namaToko.setText("Uddenly");
        totalHarga = view.findViewById(R.id.tv_totalharga);
        adapter = new PesananBarangRecyclerViewAdapter(getContext(), listBarang);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        presenter = new PesananPresenter(this);
    }

    @Override
    public void showListPesanan(ArrayList<BarangTransaksi> listPesanan) {
        listBarang.clear();
        listBarang.addAll(listPesanan);
        adapter.notifyDataSetChanged();
        setTotalHarga();
    }

    private void setTotalHarga(){
        Float total = new Float(0);
        for(BarangTransaksi barangTransaksi : listBarang){
            total += barangTransaksi.getBarang().getHarga();
        }
        Integer i = total.intValue();
        totalHarga.setText(i.toString());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
