package com.marketplace.kelompok2.kue.ui.resep;

import android.content.Context;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Favorit;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResepPresenter extends BasePresenterNetwork{

    private Call<Favorit> result;
    private ResepView view;

    public ResepPresenter(ResepView view){
        super();
        this.view = view;
    }

    public void getResep(Integer id){

    }

    public void addWishlist(Integer idResep, Context context){
        result = service.addWishlist(UserState.getInstance().getIdUser(), idResep);
        result.enqueue(new Callback<Favorit>() {
            @Override
            public void onResponse(Call<Favorit> call, Response<Favorit> response) {
                Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Favorit> call, Throwable t) {

            }
        });
    }
}
