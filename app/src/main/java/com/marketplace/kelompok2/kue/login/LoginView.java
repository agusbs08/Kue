package com.marketplace.kelompok2.kue.login;

import com.google.firebase.auth.FirebaseUser;

public interface LoginView {
    public void updateUI(FirebaseUser user);
    public void showError();
}
