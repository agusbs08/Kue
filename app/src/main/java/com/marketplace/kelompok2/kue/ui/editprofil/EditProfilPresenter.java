package com.marketplace.kelompok2.kue.ui.editprofil;

import android.util.Log;

import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilPresenter extends BasePresenterNetwork {
    private EditProfilView view;
    private String TAG = EditProfilPresenter.class.getSimpleName();
    private String method;

    public EditProfilPresenter(EditProfilView view){
        super();
        this.view = view;
        this.method ="PATCH";
    }

    public void updateUser(String username, String email, String noTlp, File image){
        RequestBody reqNama = RequestBody.create(MultipartBody.FORM, username);
        RequestBody reqMethod = RequestBody.create(MultipartBody.FORM, this.method);
  //      RequestBody reqEmail = RequestBody.create(MultipartBody.FORM, email);
        RequestBody reqNotlp = RequestBody.create(MultipartBody.FORM, noTlp);
        RequestBody requestBody = RequestBody.create(MultipartBody.FORM, image);
        MultipartBody.Part body = MultipartBody.Part.createFormData("image_pem", "image", requestBody);

        Call<ModelResponse<Pembeli>> result = service.updatePembeli(reqMethod, reqNama, reqNotlp, body, UserState.getInstance().getPembeli().getId());

        result.enqueue(new Callback<ModelResponse<Pembeli>>() {
            @Override
            public void onResponse(Call<ModelResponse<Pembeli>> call, Response<ModelResponse<Pembeli>> response) {
                if(response.isSuccessful()){
                    Pembeli pembeli = response.body().getModel();
                    UserState.getInstance().setPembeli(pembeli);
                    UserState.getInstance().setIdUser(pembeli.getId());
                    UserState.getInstance().getPembeli().setGambarPembeli(BuildConfig.BASE_STORAGE + pembeli.getGambarPembeli());
                    view.actionSuccessUpdate();
                }
                else{
                    Log.d(TAG, response.message() + " r");
                }
            }

            @Override
            public void onFailure(Call<ModelResponse<Pembeli>> call, Throwable t) {
                Log.d(TAG, t.getMessage() + " f");
            }
        });
    }
}
