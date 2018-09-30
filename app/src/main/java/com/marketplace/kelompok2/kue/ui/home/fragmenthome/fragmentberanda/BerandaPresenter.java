package com.marketplace.kelompok2.kue.ui.home.fragmenthome.fragmentberanda;

import android.util.Log;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.ui.home.fragmenthome.HomeView;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

public class BerandaPresenter extends BasePresenterNetwork {
    private HomeView view;
    private Call<DataResponse<Barang>> result;

    public BerandaPresenter(HomeView view){
        super();
        this.view = view;
    }

    public void getItems(){
        view.showLoading();
        result = super.service.getBarangsBeranda();
        result.enqueue(new Callback<DataResponse<Barang>>() {
            @Override
            public void onResponse(Call<DataResponse<Barang>> call, Response<DataResponse<Barang>> response) {
                String errroMessage = response.body().getErrorMessage();
                if (errroMessage.equals(null)) {
                    ArrayList<Barang> listData = response.body().getListData();
                    view.showItems(listData);
                }
                else{
                    view.showErrorMessage();
                }
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<DataResponse<Barang>> call, Throwable t) {
                Log.e("getData", "gagal");
                Log.e("message",t.getMessage());
            }
        });
    }
}
