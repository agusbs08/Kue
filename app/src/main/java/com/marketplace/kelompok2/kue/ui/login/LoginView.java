package com.marketplace.kelompok2.kue.ui.login;

import com.google.firebase.auth.FirebaseUser;

public interface LoginView {
    void updateUI(FirebaseUser user);
    void showError();
}
