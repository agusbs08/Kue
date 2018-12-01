package com.marketplace.kelompok2.kue.db.retrofit;

import android.database.Observable;
import android.provider.ContactsContract;
import android.view.Display;

import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.BarangTokoList;
import com.marketplace.kelompok2.kue.model.Favorit;
import com.marketplace.kelompok2.kue.model.IsiKeranjang;
import com.marketplace.kelompok2.kue.model.Keranjang;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.Penjual;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.list.BarangTransaksiList;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;
import com.marketplace.kelompok2.kue.model.list.ResepList;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.model.response.DetailTransaksi;
import com.marketplace.kelompok2.kue.model.response.KeranjangResponse;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataService {

    @Headers("Content-Type: application/json")
    @GET("api/barang")
    public Call<DataResponse<Barang>> getBarangsBeranda();

    @GET("api/resep")
    public Call<DataResponse<Resep>> getListResep();

    @GET("api/resep/{id}")
    public Call<ModelResponse<Resep>> getResep(@Path("id") String id);

    @GET("api/barang")
    public Call<DataResponse<Barang>> getBarangByKeyword(@Query("keyword") String inputKeyword);

    @FormUrlEncoded
    @POST("api/pembeli/login")
    public Call<ModelResponse<Pembeli>> getUser(@Field("email_pem") String email,
                                                @Field("password_pem") String password);

    @GET("api/penjual")
    public Call<DataResponse<Penjual>> getListPenjual();

    @FormUrlEncoded
    @POST("api/pembeli/getbyemail")
    public Call<ModelResponse<Pembeli>> getUserFromEmail(@Field("email_pem") String email);

//    @Multipart
//    @POST("api/pembeli")
//    public Call<ModelResponse<Pembeli>> registerPembeli(@Part("username_pem") String username,
//                                               @Part("password_pem") String password,
//                                               @Part("email_pem") String email,
//                                               @Part("notlp_pem") String noHp);

    @FormUrlEncoded
    @POST("api/pembeli")
    public Call<ModelResponse<Pembeli>> registerPembeli(@Field("username_pem") String username,
                                                        @Field("password_pem") String password,
                                                        @Field("email_pem") String email,
                                                        @Field("notlp_pem") String noHp);

    @FormUrlEncoded
    @POST("api/penjual/pilihan")
    public Call<DataResponse<BarangTokoList>> getListBarangPenjual(@Field("keyword") String keyword);

    @FormUrlEncoded
    @POST("api/transaksi")
    io.reactivex.Observable<ModelResponse<Barang>> uploadBarang(@Field("id_pembeli") Integer idPembeli,
                                                                @Field("id_barang") Integer idBarang,
                                                                @Field("id_detail_transaksi") Integer idDetailTransaksi,
                                                                @Field("quantity") Integer kuantitas);

    @FormUrlEncoded
    @POST("api/detailtransaksi")
    Call<ModelResponse<DetailTransaksi>> setDetailTransaksi(@Field("status_pembayaran") String statusPembayaran,
                                                            @Field("status_proses") String statusProses,
                                                            @Field("status_pengiriman") String statusPengiriman,
                                                            @Field("status_penerimaan") String statusPenerimaan,
                                                            @Field("total_harga_transaksi") Integer totalHargaTransaksi,
                                                            @Field("metode_pembayaran") String metodePembayaran);

    @FormUrlEncoded
    @POST("api/isikeranjang")
    io.reactivex.Observable<ModelResponse<IsiKeranjang>> addToChart(@Field("id_keranjang") Integer idKeranjang,
                                                                    @Field("id_barang") Integer idBarang,
                                                                    @Field("quantity_barang") Integer kuantitas);

    @FormUrlEncoded
    @POST("api/keranjang")
    Call<ModelResponse<Keranjang>> setCart(@Field("id_pembeli") Integer idPembeli,
                                               @Field("total_harga_keranjang") Integer total);

    @GET("api/favorit/{id_pembeli}")
    Call<ResepList> getAllWishlist(@Path("id_pembeli") Integer idUser);

    @FormUrlEncoded
    @POST("api/favorit")
    Call<Favorit> addWishlist(@Field("id_pembeli") Integer idUser,
                              @Field("id_resep") Integer idResep);

    @DELETE("api/favorit/{id_favorit}")
    Call<ModelResponse<Favorit>> deleteWishlist(@Path("id_favorit") Integer idFavorit);

   @GET("api/isikeranjang/{id_keranjang}")
    Call<KeranjangResponse> getALlKeranjang(@Path("id_keranjang") Integer idKeranjang);

   @GET("api/transaksi")
    Call<DataResponse<BarangTransaksiList>> getAllTransaksi(@Query("id_pembeli") Integer idUser);

   @DELETE("api/isikeranjang/{id_keranjang}")
    io.reactivex.Observable<ModelResponse<BarangKeranjang>> deleteKeranjang(@Path("id_keranjang") Integer idKeranjang);

}
