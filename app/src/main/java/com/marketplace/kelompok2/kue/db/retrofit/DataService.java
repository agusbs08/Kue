package com.marketplace.kelompok2.kue.db.retrofit;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.response.DataResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {

    @Headers("Content-Type: application/json")
    @GET("/api/barang")
    public Call<DataResponse<Barang>> getBarangsBeranda();

    @GET("api/barang")
    public Call<DataResponse<Barang>> getBarangByKeyword(@Query("keyword") String inputKeyword);

    @GET("api/pembeli")
    public Call<DataResponse<Pembeli>> getPembeliFromEmail(@Query("email_pem") String email);

    @FormUrlEncoded
    @POST("api/pembeli/login")
    public Call<DataResponse<Pembeli>> getUser(@Field("email_pem") String email, @Field("password_pem") String password);

    @FormUrlEncoded
    @POST("api/pembeli/register")
    public Call<DataResponse<Pembeli>> registerPembeli(@Field("username_pem") String username,
                                                       @Field("password_pem") String password,
                                                       @Field("email_pem") String email);
}
