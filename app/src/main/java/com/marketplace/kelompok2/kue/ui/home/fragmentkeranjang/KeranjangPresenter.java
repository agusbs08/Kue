package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.util.Log;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;
import com.marketplace.kelompok2.kue.model.response.KeranjangResponse;

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
        Call<KeranjangResponse> result = service.getALlKeranjang(idKeranjang);
        result.enqueue(new Callback<KeranjangResponse>() {
            @Override
            public void onResponse(Call<KeranjangResponse> call, Response<KeranjangResponse> response) {
                if(response.isSuccessful()){
                    Log.e("getListKeranjangr", "success");
                    view.showListKeranjang(response.body());
                }
                else{
                    Log.e("getListKeranjangr", response.message());
                }
            }

            @Override
            public void onFailure(Call<KeranjangResponse> call, Throwable t) {
                Log.e("getListKeranjangf", t.getMessage());
            }
        });
    }

}
