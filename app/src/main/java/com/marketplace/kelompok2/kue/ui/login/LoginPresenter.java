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
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.base.BasePresenterNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenterNetwork{
    private LoginView view;
    private FirebaseAuth mAuth;
    private AppCompatActivity activity;
    private Call<DataResponse<Pembeli>> result;
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

    public void getPembeli(String email, String password){
        result = super.service.getUser(email, password);
        result.enqueue(new Callback<DataResponse<Pembeli>>() {
            @Override
            public void onResponse(Call<DataResponse<Pembeli>> call, Response<DataResponse<Pembeli>> response) {
                if(response.body().getErrorMessage() == null){
                    Pembeli pembeli = response.body().getListData().get(0);
                    view.actionLoginSuccess(pembeli.getId());
                }
            }

            @Override
            public void onFailure(Call<DataResponse<Pembeli>> call, Throwable t) {
                view.showError();
            }
        });
    }

    public void getPembeli(String email){

    }
}

