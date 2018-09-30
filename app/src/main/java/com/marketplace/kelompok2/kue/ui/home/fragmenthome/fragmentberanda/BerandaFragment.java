package com.marketplace.kelompok2.kue.ui.home.fragmenthome.fragmentberanda;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.HomeRecyclerViewAdapter;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.HomeView;

import java.util.ArrayList;

public class BerandaFragment extends Fragment implements HomeView {

    private RecyclerView listEvent;
    private ProgressBar progressBar;
    private ArrayList<Barang> barangs;
    private BerandaPresenter presenter;
    private HomeRecyclerViewAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getItems();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beranda, container, false);
        listEvent = (RecyclerView)rootView.findViewById(R.id.list_barang_beranda);
        progressBar = (ProgressBar)rootView.findViewById(R.id.pb_fragment_beranda);
        init();
        return rootView;
    }


    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showItems(ArrayList<Barang> listBarang) {
        barangs.addAll(listBarang);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {

    }

    private void init(){
        barangs = new ArrayList<>();
        adapter = new HomeRecyclerViewAdapter(getContext(), barangs);
        presenter = new BerandaPresenter(this);
        listEvent.setLayoutManager(new GridLayoutManager(getContext(), 2));
        listEvent.setAdapter(adapter);

    }
}
