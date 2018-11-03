package com.marketplace.kelompok2.kue.db.retrofit;

import com.marketplace.kelompok2.kue.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceClient {
    private static RetrofitInstanceClient instance = null;
    private Retrofit retrofit;

    private RetrofitInstanceClient(){
        init();
    }

    private void init(){
        retrofit = new Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public static RetrofitInstanceClient getInstance(){
        if(instance == null){
            instance = new RetrofitInstanceClient();
        }
        return instance;
    }
}
