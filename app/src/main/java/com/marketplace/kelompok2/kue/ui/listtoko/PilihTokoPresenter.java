package com.marketplace.kelompok2.kue.ui.listtoko;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangTokoList;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PilihTokoPresenter extends BasePresenterNetwork {

    private Call<DataResponse<BarangTokoList>> result;
    private PilihTokoView view;

    public PilihTokoPresenter(PilihTokoView view){
        super();
        this.view = view;
    }

    public void getListToko(ArrayList<Barang> listBarang){

    }

    public void getListToko(String keyword){
        view.hideLoading();
        result = super.service.getListBarangPenjual(keyword);

        result.enqueue(new Callback<DataResponse<BarangTokoList>>() {
            @Override
            public void onResponse(Call<DataResponse<BarangTokoList>> call, Response<DataResponse<BarangTokoList>> response) {
                ArrayList<BarangTokoList> listBarangPenjual = response.body().getListData();
                view.showListKeranjang(listBarangPenjual);
            }

            @Override
            public void onFailure(Call<DataResponse<BarangTokoList>> call, Throwable t) {

            }
        });
    }
}
