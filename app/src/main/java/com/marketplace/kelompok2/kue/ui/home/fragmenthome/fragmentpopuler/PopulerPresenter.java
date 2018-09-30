package com.marketplace.kelompok2.kue.ui.home.fragmenthome.fragmentpopuler;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.HomeView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopulerPresenter extends BasePresenterNetwork {
    private HomeView view;
    private Call<DataResponse<Barang>> result;

    public PopulerPresenter(HomeView view){
        super();
        this.view = view;
    }

    public void getItemsPopuler(){
        result = super.service.getBarangsBeranda();
        result.enqueue(new Callback<DataResponse<Barang>>() {
            @Override
            public void onResponse(Call<DataResponse<Barang>> call, Response<DataResponse<Barang>> response) {
                ArrayList<Barang> listData = response.body().getListData();
                view.showItems(listData);
                view.hideLoading();

            }

            @Override
            public void onFailure(Call<DataResponse<Barang>> call, Throwable t) {
                view.showErrorMessage();
            }
        });
    }
}
