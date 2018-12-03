package com.marketplace.kelompok2.kue.ui.listresepper;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.response.DataResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResepKhususPresenter extends BasePresenterNetwork {
    private ResepKhususView view;
    private Call<DataResponse<Resep>> result;

    public ResepKhususPresenter(ResepKhususView view){
        super();
        this.view = view;
    }

    public void getListResepKategori(int id){
        view.showLoading();
        result = service.getListResepFromKategori(id);
        enqueue();
    }

    public void getListResepChef(int id){
        result = service.getListResepFromChef(id);
        enqueue();
    }

    private void enqueue(){
        result.enqueue(new Callback<DataResponse<Resep>>() {
            @Override
            public void onResponse(Call<DataResponse<Resep>> call, Response<DataResponse<Resep>> response) {
                ArrayList<Resep> listResep = response.body().getListData();
                view.showListResep(listResep);
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<DataResponse<Resep>> call, Throwable t) {

            }
        });
    }
}
