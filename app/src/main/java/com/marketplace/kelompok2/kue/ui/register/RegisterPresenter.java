package com.marketplace.kelompok2.kue.ui.register;

import android.support.v7.widget.RecyclerView;

import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.base.BasePresenterNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter extends BasePresenterNetwork{
    private RegisterView view;
    private Call<DataResponse<Pembeli>> result;
    private Pembeli user;

    public RegisterPresenter(RegisterView view){
        super();
        this.view = view;
        this.user = null;
    }

    public void register(String nama, String password, String email, String noHp){
       result = super.service.registerPembeli(nama, password, email);

       result.enqueue(new Callback<DataResponse<Pembeli>>() {
           @Override
           public void onResponse(Call<DataResponse<Pembeli>> call, Response<DataResponse<Pembeli>> response) {
               Pembeli pembeli = response.body().getListData().get(0);
               view.actionRegisterSuccess(pembeli.getId());
           }

           @Override
           public void onFailure(Call<DataResponse<Pembeli>> call, Throwable t) {
                view.actionRegisterFailed();
           }
       });
    }

    public Pembeli getPembeli(String email){
        result = super.service.getPembeliFromEmail(email);
        result.enqueue(new Callback<DataResponse<Pembeli>>() {
            @Override
            public void onResponse(Call<DataResponse<Pembeli>> call, Response<DataResponse<Pembeli>> response) {
                if(response.body().getErrorMessage() == null){
                    setUser(response.body().getListData().get(0));
                }
            }

            @Override
            public void onFailure(Call<DataResponse<Pembeli>> call, Throwable t) {

            }
        });
        return getUser();
    }

    private Pembeli getUser() {
        return user;
    }

    private void setUser(Pembeli user) {
        this.user = user;
    }
}
