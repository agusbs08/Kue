package com.marketplace.kelompok2.kue.ui.resep;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Favorit;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.ResepFavorit;
import com.marketplace.kelompok2.kue.model.list.ResepList;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;

import java.util.ArrayList;

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

    public void getResepStatus(Integer idResep, Context context, int state){
        Call<ResepList> result = service.getAllWishlist(UserState.getInstance().getIdUser());

        result.enqueue(new Callback<ResepList>() {
            @Override
            public void onResponse(Call<ResepList> call, Response<ResepList> response) {
                if(response.isSuccessful()){
                    ArrayList<ResepFavorit> listResep = response.body().getListResep();
                    boolean flag = false;
                    Integer idFavorit = 0;
                    for(ResepFavorit resepFavorit : listResep){
                        if(idResep == resepFavorit.getResep().getId()){
                            flag = true;
                            idFavorit = resepFavorit.getIdFavorit();
                            break;
                        }
                    }
                    if(state == 1){
                        Toast.makeText(context, "Add Success " , Toast.LENGTH_SHORT).show();
                    }
                    view.setImageWishlist(flag, idFavorit);
                }
            }

            @Override
            public void onFailure(Call<ResepList> call, Throwable t) {

            }
        });
    }

    public void addWishlist(Integer idResep, Context context){
        result = service.addWishlist(UserState.getInstance().getIdUser(), idResep);
        result.enqueue(new Callback<Favorit>() {
            @Override
            public void onResponse(Call<Favorit> call, Response<Favorit> response) {
                getResepStatus(idResep, context, 1);
            }

            @Override
            public void onFailure(Call<Favorit> call, Throwable t) {

            }
        });
    }

    public void deleteWishlist(Integer idFavorit, Context context){
        Call<ModelResponse<Favorit>> result = service.deleteWishlist(idFavorit);

        result.enqueue(new Callback<ModelResponse<Favorit>>() {
            @Override
            public void onResponse(Call<ModelResponse<Favorit>> call, Response<ModelResponse<Favorit>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, "Delete Success", Toast.LENGTH_SHORT).show();
                    view.setImageWishlist(false,0);
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
