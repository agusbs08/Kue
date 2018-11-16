package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.list.BarangTransaksiList;

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
        Call<BarangTransaksiList> result = service.getAllTransaksi(idUser);
        result.enqueue(new Callback<BarangTransaksiList>() {
            @Override
            public void onResponse(Call<BarangTransaksiList> call, Response<BarangTransaksiList> response) {
                if(response.isSuccessful()){
                    view.showListPesanan(response.body().getListBarang());
                }
            }

            @Override
            public void onFailure(Call<BarangTransaksiList> call, Throwable t) {

            }
        });
    }

}
