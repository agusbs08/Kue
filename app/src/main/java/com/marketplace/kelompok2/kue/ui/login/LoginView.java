package com.marketplace.kelompok2.kue.ui.login;

import com.google.firebase.auth.FirebaseUser;
import com.marketplace.kelompok2.kue.base.BaseView;

public interface LoginView extends BaseView{
    void updateUI(FirebaseUser user);
    void showError();
    void actionLoginSuccess(Integer id);
}
