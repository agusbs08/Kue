package com.marketplace.kelompok2.kue.base;

import com.marketplace.kelompok2.kue.db.retrofit.DataService;
import com.marketplace.kelompok2.kue.db.retrofit.RetrofitInstanceClient;

import retrofit2.Retrofit;

public class BasePresenterNetwork {
    public Retrofit retrofit;
    public DataService service;

    public BasePresenterNetwork(){
        this.retrofit = RetrofitInstanceClient.getInstance().getRetrofit();
        this.service = retrofit.create(DataService.class);
    }
}
