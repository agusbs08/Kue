package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.util.Log;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KeranjangPresenter extends BasePresenterNetwork {
    KeranjangView view;

    public KeranjangPresenter(KeranjangView view){
        super();
        this.view = view;
    }

    public void getListKeranjang(Integer idKeranjang){
        Call<KeranjangList> result = service.getALlKeranjang(idKeranjang);
        result.enqueue(new Callback<KeranjangList>() {
            @Override
            public void onResponse(Call<KeranjangList> call, Response<KeranjangList> response) {
                if(response.isSuccessful()){
                   view.showListKeranjang(response.body().getListBarang());
                }
                else{
                    Log.e("listpesanan", response.message());
                }
            }

            @Override
            public void onFailure(Call<KeranjangList> call, Throwable t) {
                Log.e("listpesananf", t.getMessage());
            }
        });
    }

}
