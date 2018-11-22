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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.BarangTransaksi;
import com.marketplace.kelompok2.kue.model.list.BarangTransaksiList;

import java.util.ArrayList;

/**
 * Created by ridho on 05/10/18.
 */

public class PesananFragment extends Fragment implements PesananView{

    private RecyclerView recyclerView;
    private PesananRecyclerViewAdapter adapter;
    private PesananPresenter presenter;
    private ArrayList<BarangTransaksiList> listBarangTransaksi;
    private ProgressBar pb;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideLoading();
        presenter.getListTransaksi(UserState.getInstance().getIdUser());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pesanan, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view){
        listBarangTransaksi = new ArrayList<>();
        pb = view.findViewById(R.id.pb_daftar_pesanan);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new PesananRecyclerViewAdapter(listBarangTransaksi, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        presenter = new PesananPresenter(this);
    }

    @Override
    public void showListPesanan(ArrayList<BarangTransaksiList> listPesanan) {
        listBarangTransaksi.clear();
        listBarangTransaksi.addAll(listPesanan);
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
