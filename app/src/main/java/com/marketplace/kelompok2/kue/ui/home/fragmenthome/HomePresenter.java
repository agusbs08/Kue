package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import com.marketplace.kelompok2.kue.model.KategoriResep;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter extends BasePresenterNetwork {

    private HomeView view;
    private Call<DataResponse<Resep>> result;

    public HomePresenter(HomeView view){
        super();
        this.view = view;
    }

    public void getListResep(){
        view.showLoading();
        result = service.getListResep();

        result.enqueue(new Callback<DataResponse<Resep>>() {
            @Override
            public void onResponse(Call<DataResponse<Resep>> call, Response<DataResponse<Resep>> response) {
                ArrayList<Resep> listResep = response.body().getListData();
//                view.hideLoading();
//                view.showListResep(listResep);
                getListKategoriResep(listResep);
            }

            @Override
            public void onFailure(Call<DataResponse<Resep>> call, Throwable t) {
                view.showErrorMessage();
            }
        });
    }

    private void getListKategoriResep(ArrayList<Resep> listResep){
        Call<DataResponse<KategoriResep>> results = service.getAllKategoriResep();

        results.enqueue(new Callback<DataResponse<KategoriResep>>() {
            @Override
            public void onResponse(Call<DataResponse<KategoriResep>> call, Response<DataResponse<KategoriResep>> response) {
                ArrayList<KategoriResep> listKategoriResep = response.body().getListData();
                view.hideLoading();
                view.showListResep(listResep, listKategoriResep);
            }

            @Override
            public void onFailure(Call<DataResponse<KategoriResep>> call, Throwable t) {

            }
        });
    }
}
