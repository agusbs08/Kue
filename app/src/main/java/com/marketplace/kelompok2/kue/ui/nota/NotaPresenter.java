package com.marketplace.kelompok2.kue.ui.nota;

import android.util.Log;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.response.DetailTransaksi;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotaPresenter extends BasePresenterNetwork {
    private NotaView view;

    public NotaPresenter(NotaView view){
        super();
        this.view = view;
    }

    public void setTransaksi(ArrayList<Barang> listBarang, Float total){
        view.showLoading();
        Call<ModelResponse<DetailTransaksi>> result = service.setDetailTransaksi("Belum Terbayar",
                "Sedang Diproses",
                "Dikirm",
                "Belum diterima",
                total.intValue(),
                "Bayar Ditempat");

        result.enqueue(new Callback<ModelResponse<DetailTransaksi>>() {
            @Override
            public void onResponse(Call<ModelResponse<DetailTransaksi>> call, Response<ModelResponse<DetailTransaksi>> response) {
                if(response.isSuccessful()){
                    Log.d("getDetailTransaksi","Berhasil");
                    uploadListBarang(listBarang, response.body().getModel().getId());
                }
                else{
                    Log.d("getDetailTransaksir",response.message());
                }
            }

            @Override
            public void onFailure(Call<ModelResponse<DetailTransaksi>> call, Throwable t) {
                Log.d("getDetailTransaksif",t.getMessage());
            }
        });
    }

    private void uploadListBarang(ArrayList<Barang> listBarang, Integer idDetailTransaksi){
        Observable.fromIterable(listBarang)
                .flatMap(barang -> service.uploadBarang(UserState.getInstance().getIdUser(),
                                                        barang.getId(),
                                                        idDetailTransaksi,
                                                        1))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( modelResponses -> {
                    view.hideLoading();
                    view.showActionSuccess();
                },throwable -> {
                    Log.e("error",throwable.getMessage());
                });
    }
}
