package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;
import com.marketplace.kelompok2.kue.model.response.KeranjangResponse;
import com.marketplace.kelompok2.kue.ui.nota.NotaActivity;

import java.util.ArrayList;

public class KeranjangFragment extends Fragment implements KeranjangView {


    private ArrayList<KeranjangList> listKeranjang;
    private KeranjangResponse keranjangResponse;
    private KeranjangPresenter presenter;
    private Button btnBayar;
    private RecyclerView recyclerView;
    private KeranjangRecyclerViewAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getListKeranjang(UserState.getInstance().getPembeli().getIdKeranjang());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_keranjang, container, false);
        initView(rootView);
        initBtnChekout();
        return rootView;
    }

    private void initView(View rootView){
        listKeranjang = new ArrayList<>();
        btnBayar = rootView.findViewById(R.id.btn_bayar_keranjang);
        recyclerView = rootView.findViewById(R.id.recyclerview_fragment_keranjang);
        adapter = new KeranjangRecyclerViewAdapter(getContext(), listKeranjang);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        presenter = new KeranjangPresenter(this);
    }

    @Override
    public void showListKeranjang(KeranjangResponse keranjangResponse) {
        this.keranjangResponse = keranjangResponse;
        this.listKeranjang.clear();
        this.listKeranjang.addAll(keranjangResponse.getListKeranjang());
        this.adapter.notifyDataSetChanged();
        setTotalHarga();
    }

    private void setTotalHarga(){
        Float total = new Float(0);
        for(KeranjangList keranjangList : listKeranjang){
            for(BarangKeranjang barangKeranjang : keranjangList.getListBarang()){
                total += barangKeranjang.getBarang().getHarga();
            }
        }
        Integer harga = total.intValue();
        Log.e("total", harga.toString());
        btnBayar.setText("Bayar: Rp " + harga.toString());
        Log.e("total", harga.toString());
    }

    private void initBtnChekout(){
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NotaActivity.class);
                intent.putExtra("keranjangResponse" , keranjangResponse);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
