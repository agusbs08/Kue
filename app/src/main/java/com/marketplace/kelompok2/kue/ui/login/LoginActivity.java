package com.marketplace.kelompok2.kue.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.marketplace.kelompok2.kue.BerhasilActivity;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.service.NotifikasiService;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.marketplace.kelompok2.kue.ui.register.RegisterActivity;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements LoginView{
    public final int RC_SIGN_IN = 234;
    private GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    private LoginPresenter presenter;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponent();
        init();
        findViewById(R.id.default_google_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(mGoogleSignInClient.getSignInIntent(), RC_SIGN_IN);
            }
        });

        hideLoading();
    }

    private void init(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmail(etUsername.getText().toString())){
                    presenter.checkUser(etUsername.getText().toString(), etPassword.getText().toString());
                }
                else{
                    showError();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponent(){
        etUsername = findViewById(R.id.et_username_login);
        etPassword = findViewById(R.id.et_password_login);
        btnLogin = findViewById(R.id.btn_login_login);
        tvRegister = findViewById(R.id.tv_daftar_login);
        pb = findViewById(R.id.pb_login);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        presenter = new LoginPresenter(this, FirebaseAuth.getInstance(), this);
    }

    private boolean checkEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                presenter.firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                showError();
            }
        }
    }

    @Override
    public void updateUI(FirebaseUser user){
        if(user != null){
            presenter.checkUserFromEmail(user.getEmail());
        }
        else{
            showError();
        }
    }
    @Override
    public void showError(){
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actionLoginSuccess(Pembeli pembeli) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        UserState.getInstance().setIdUser(pembeli.getId());
        UserState.getInstance().setPembeli(pembeli);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }
}
