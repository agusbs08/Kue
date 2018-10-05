package com.marketplace.kelompok2.kue.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.marketplace.kelompok2.kue.BerhasilActivity;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.marketplace.kelompok2.kue.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{
    public final int RC_SIGN_IN = 234;
    private GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    private LoginPresenter presenter;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initComponent();
        setViewAction();
    }

    private void initView(){
        etUsername = findViewById(R.id.et_username_login);
        etPassword = findViewById(R.id.et_password_login);
        btnLogin = findViewById(R.id.btn_login_login);
        tvRegister = findViewById(R.id.tv_daftar_login);
    }

    private void initComponent(){
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        presenter = new LoginPresenter(this, FirebaseAuth.getInstance(), this);
    }

    private void setViewAction(){
        findViewById(R.id.default_google_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(mGoogleSignInClient.getSignInIntent(), RC_SIGN_IN);
            }
        });

        Button tes = (Button)findViewById(R.id.tes);
        tes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals("")
                        && etPassword.getText().toString().equals("")){
                   Toast.makeText(getApplicationContext(), "Isi field yang kosong"
                           , Toast.LENGTH_SHORT).show();
                }
                else{
                    presenter.getPembeli(etUsername.getText().toString(),
                            etPassword.getText().toString());
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
                Toast.makeText(LoginActivity.this, "Gagal API", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void updateUI(FirebaseUser user){
        if(user != null){
            presenter.getPembeli(user.getEmail());
        }
    }
    @Override
    public void showError(){
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actionLoginSuccess() {

    }

}
