package com.marketplace.kelompok2.kue.ui.home.fragmentwishlist;

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
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.ResepFavorit;
import com.marketplace.kelompok2.kue.model.list.ResepList;

import java.util.ArrayList;

public class WishlistFragment extends Fragment implements WishlistView{

    private RecyclerView recyclerView;
    private WishlistRecyclerViewAdapter adapter;
    private ArrayList<ResepFavorit> resepFavorits;
    private ProgressBar pb;
    private WishlistPresenter presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideLoading();
        presenter.getListWishlist(UserState.getInstance().getIdUser());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wishlist, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view){
        resepFavorits = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rv_listresep_wishlist);
        pb = view.findViewById(R.id.pb_fragment_wishlist);
        adapter = new WishlistRecyclerViewAdapter(resepFavorits, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        presenter = new WishlistPresenter(this);
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void showListWishlist(ArrayList<ResepFavorit> listResepFavorit) {
        this.resepFavorits.clear();
        this.resepFavorits.addAll(listResepFavorit);
        adapter.notifyDataSetChanged();
    }
}
