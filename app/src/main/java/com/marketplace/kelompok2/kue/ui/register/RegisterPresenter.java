package com.marketplace.kelompok2.kue.ui.register;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter extends BasePresenterNetwork{
    private RegisterView view;
    private Call<ModelResponse<Pembeli>> result;

    public RegisterPresenter(RegisterView view){
        super();
        this.view = view;
    }

    public void register(String nama, String email, String password, String nohp){
        view.showLoading();
        result = service.registerPembeli(nama, password, email, nohp);
        result.enqueue(new Callback<ModelResponse<Pembeli>>() {
            @Override
            public void onResponse(Call<ModelResponse<Pembeli>> call, Response<ModelResponse<Pembeli>> response) {
                if(response.isSuccessful()){
                    Pembeli pembeli = response.body().getModel();
                    view.hideLoading();
                    view.actionRegisterSuccess(pembeli);
                }
                else {
                    Log.e("registerr", response.message());
                    view.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse<Pembeli>> call, Throwable t) {
                Log.d("register", t.getMessage());
                view.hideLoading();
                view.showError();
            }
        });
    }

}
