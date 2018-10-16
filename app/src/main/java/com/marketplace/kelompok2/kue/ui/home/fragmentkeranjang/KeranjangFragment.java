package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Keranjang;

import java.util.ArrayList;

public class KeranjangFragment extends Fragment implements KeranjangView {

    private TextView tvBayar;
    private RecyclerView recyclerView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_keranjang, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView){
//        tvBayar = rootView.findViewById(R.id.tv_bayar_keranjang);
//        recyclerView = rootView.findViewById(R.id.recyclerview_fragment_keranjang);
    }

    @Override
    public void showListKeranjang(ArrayList<Keranjang> keranjangs) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
