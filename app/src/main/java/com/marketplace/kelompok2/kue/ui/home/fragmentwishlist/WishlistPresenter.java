package com.marketplace.kelompok2.kue.ui.home.fragmentwishlist;

import android.util.Log;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.list.ResepList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishlistPresenter extends BasePresenterNetwork{
    private WishlistView view;
    private Call<ResepList> result;

    public WishlistPresenter(WishlistView view){
        super();
        this.view = view;
    }

    public void getListWishlist(Integer idUser){
        view.showLoading();
        result = service.getAllWishlist(idUser);
        result.enqueue(new Callback<ResepList>() {
            @Override
            public void onResponse(Call<ResepList> call, Response<ResepList> response) {
               if(response.isSuccessful()){
                   view.hideLoading();
                   Integer s = response.body().getListResep().size();
                   Log.e("getAllWishlist", s.toString());
                   view.showListWishlist(response.body().getListResep());
               }
               else{
                   Log.e("getAllWishlistr", response.message());
               }
            }

            @Override
            public void onFailure(Call<ResepList> call, Throwable t) {
                view.hideLoading();
                Log.e("getAllWishlist", t.getMessage());
            }
        });
    }
}
