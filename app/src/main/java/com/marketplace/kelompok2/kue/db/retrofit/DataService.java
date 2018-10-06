package com.marketplace.kelompok2.kue.db.retrofit;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.response.DataResponse;

import retrofit2.CallAdapter;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DataService {

    @Headers("Content-Type: application/json")
    @GET("/api/barang")
    public Call<DataResponse<Barang>> getBarangsBeranda();

    @GET("api/barang")
    public Call<DataResponse<Barang>> getBarangByKeyword(@Query("keyword") String inputKeyword);

}
