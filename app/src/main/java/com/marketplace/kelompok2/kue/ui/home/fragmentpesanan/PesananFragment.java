package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Pesanan;

import java.util.ArrayList;

/**
 * Created by ridho on 05/10/18.
 */

public class PesananFragment extends Fragment implements PesananView{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pesanan, container, false);

        return rootView;
    }

    @Override
    public void showListPesanan(ArrayList<Pesanan> listPesanan) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
