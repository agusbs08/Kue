package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import android.util.Log;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.list.BarangTransaksiList;
import com.marketplace.kelompok2.kue.model.response.DataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesananPresenter extends BasePresenterNetwork {
    PesananView view;

    public PesananPresenter(PesananView view){
        super();
        this.view = view;
    }

    public void getListTransaksi(Integer idUser){
        view.showLoading();
        Call<DataResponse<BarangTransaksiList>> result = service.getAllTransaksi(idUser);
        result.enqueue(new Callback<DataResponse<BarangTransaksiList>>() {
            @Override
            public void onResponse(Call<DataResponse<BarangTransaksiList>> call, Response<DataResponse<BarangTransaksiList>> response) {
                if(response.isSuccessful()){
                    view.hideLoading();
                    view.showListPesanan(response.body().getListData());
                }
                else{
                    Log.e("getListPesananr", response.message());
                }
            }

            @Override
            public void onFailure(Call<DataResponse<BarangTransaksiList>> call, Throwable t) {
                Log.e("getListPesananf", t.getMessage());
            }
        });
    }

}
