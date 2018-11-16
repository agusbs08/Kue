package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.Keranjang;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.marketplace.kelompok2.kue.ui.nota.NotaActivity;

import java.util.ArrayList;

public class KeranjangFragment extends Fragment implements KeranjangView {

    private TextView namaToko;
    private TextView totalHarga;
    private RecyclerView recyclerView;
    private Button btnBayar;
    private KeranjangRecyclerViewAdapter adapter;
    private ArrayList<BarangKeranjang> listBarang;
    private KeranjangPresenter presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getListKeranjang(UserState.getInstance().getPembeli().getIdKeranjang());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_keranjang, container, false);
        initView(rootView);
        initBtnChekout();
        return rootView;
    }

    private void initView(View rootView){
        listBarang = new ArrayList<>();
        namaToko = rootView.findViewById(R.id.tv_namatoko_keranjang);
        totalHarga = rootView.findViewById(R.id.tv_totalharga_keranjang);
        recyclerView = rootView.findViewById(R.id.rv_listbarang_keranjang);
        btnBayar = rootView.findViewById(R.id.btn_bayar_keranjang);
        adapter = new KeranjangRecyclerViewAdapter(getContext(), listBarang);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        presenter = new KeranjangPresenter(this);
    }

    @Override
    public void showListKeranjang(ArrayList<BarangKeranjang> keranjangs) {
        listBarang.clear();
        listBarang.addAll(keranjangs);
        setTotalHarga();
        adapter.notifyDataSetChanged();
    }

    private void setTotalHarga(){
        Float total = new Float(0);
        for(BarangKeranjang barangKeranjang : listBarang){
            total += barangKeranjang.getBarang().getHarga();
        }
        Integer i = total.intValue();
        totalHarga.setText(i.toString());
    }

    private void initBtnChekout(){
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Barang> list = new ArrayList<>();
                for(BarangKeranjang barangKeranjang : listBarang){
                    list.add(barangKeranjang.getBarang());
                }
                BarangList barangList = new BarangList(list);
                Intent intent = new Intent(getContext(), NotaActivity.class);
                intent.putExtra("listBarang", barangList);
                intent.putExtra("listKeranjang", listBarang);
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
