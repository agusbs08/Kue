package com.marketplace.kelompok2.kue.ui.home.fragmentwishlist;

import android.util.Log;

import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.Favorit;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishlistRecyclerViewPresenter extends BasePresenterNetwork{
    private Call<ModelResponse<Favorit>> result;
    private WishlistRecyclerViewView view;

    public WishlistRecyclerViewPresenter(WishlistRecyclerViewView view){
        super();
        this.view = view;
    }

    public void deleteWishlist(Integer idFavorit){
        result = service.deleteWishlist(idFavorit);

        result.enqueue(new Callback<ModelResponse<Favorit>>() {
            @Override
            public void onResponse(Call<ModelResponse<Favorit>> call, Response<ModelResponse<Favorit>> response) {
                if(response.isSuccessful()){
                    view.showActionDeleteSuccess();
                }
                else{
                    Log.e("deleteWishlist", response.message());
                }
            }

            @Override
            public void onFailure(Call<ModelResponse<Favorit>> call, Throwable t) {
                Log.e("deletewishlistf", t.getMessage());
            }
        });
    }
}
