package com.marketplace.kelompok2.kue.ui.base;

import com.marketplace.kelompok2.kue.db.retrofit.DataService;
import com.marketplace.kelompok2.kue.db.retrofit.RetrofitInstanceClient;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.View;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BasePresenterNetwork {
    public Retrofit retrofit;
    public DataService service;

    public BasePresenterNetwork(){
        this.retrofit = RetrofitInstanceClient.getInstance().getRetrofit();
        this.service = retrofit.create(DataService.class);
    }
}
