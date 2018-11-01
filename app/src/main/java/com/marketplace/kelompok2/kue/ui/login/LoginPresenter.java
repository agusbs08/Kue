package com.marketplace.kelompok2.kue.ui.login;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.response.ModelResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenterNetwork{
    private LoginView view;
    private FirebaseAuth mAuth;
    private AppCompatActivity activity;
    private Call<ModelResponse<Pembeli>> result;

    public LoginPresenter(LoginView view, FirebaseAuth mAuth, AppCompatActivity activity){
        super();
        this.view = view;
        this.mAuth = mAuth;
        this.activity = activity;
    }

    public void firebaseAuthWithGoogle(GoogleSignInAccount acct){
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("sign in", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            view.updateUI(user);
                        }
                        else{
                            view.showError();
                        }
                    }
                });
    }

    public void checkUser(String email, String password){
        view.showLoading();
        Pembeli pembeli = new Pembeli();
        setPembeli(pembeli, email, password);

        result = service.getUser(email, password);
        result.enqueue(new Callback<ModelResponse<Pembeli>>() {
            @Override
            public void onResponse(Call<ModelResponse<Pembeli>> call, Response<ModelResponse<Pembeli>> response) {
                if(response.isSuccessful()){
                    Pembeli pembeli1 = response.body().getModel();
                    Log.d("Success", response.message());
                    view.hideLoading();
                    view.actionLoginSuccess(pembeli1.getId());
                }
                else{
                    view.hideLoading();
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse<Pembeli>> call, Throwable t) {
                view.showError();
                view.hideLoading();
            }
        });
    }

    private void setPembeli(Pembeli pembeli, String email, String password){
        pembeli.setEmail(email);
        pembeli.setPassword(password);
    }


    public void checkUserFromEmail(String email){
        view.showLoading();
        result = service.getUserFromEmail(email);
        result.enqueue(new Callback<ModelResponse<Pembeli>>() {
            @Override
            public void onResponse(Call<ModelResponse<Pembeli>> call, Response<ModelResponse<Pembeli>> response) {
                if(response.isSuccessful()){
                    Pembeli pembeli1 = response.body().getModel();
                    view.hideLoading();
                    view.actionLoginSuccess(pembeli1.getId());
                }
                else{
                    view.hideLoading();
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse<Pembeli>> call, Throwable t) {
                view.showError();
                view.hideLoading();
            }
        });
    }

}

