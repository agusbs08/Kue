package com.marketplace.kelompok2.kue.ui.listtoko;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PilihTokoPresenter extends BasePresenterNetwork {

    private Call<DataResponse<Penjual>> result;
    private PilihTokoView view;

    public PilihTokoPresenter(PilihTokoView view){
        super();
        this.view = view;
    }

    public void getListToko(ArrayList<Barang> listBarang){

    }

    public void getListToko(){
        view.hideLoading();
        result = super.service.getListPenjual();
        result.enqueue(new Callback<DataResponse<Penjual>>() {
            @Override
            public void onResponse(Call<DataResponse<Penjual>> call, Response<DataResponse<Penjual>> response) {
                ArrayList<Penjual> listPenjual = response.body().getListData();
                view.showListKeranjang(listPenjual);
            }

            @Override
            public void onFailure(Call<DataResponse<Penjual>> call, Throwable t) {

            }
        });
    }
}
