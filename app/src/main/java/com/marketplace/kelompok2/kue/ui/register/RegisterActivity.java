package com.marketplace.kelompok2.kue.ui.register;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etRePassword;
    private EditText etNoHp;
    private Button btnDaftar;
    private RegisterPresenter presenter;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initComponent();
        initActionView();
    }

    private void initView(){
        etUsername = findViewById(R.id.et_username_register);
        etPassword = findViewById(R.id.et_password_register);
        etRePassword = findViewById(R.id.et_repassword_register);
        etEmail = findViewById(R.id.et_email_register);
        etNoHp = findViewById(R.id.et_nohp_register);
        btnDaftar = findViewById(R.id.btn_daftar_register);
        pb = findViewById(R.id.pb_register);
    }

    private void initComponent(){
        presenter = new RegisterPresenter(this);
    }

    private void initActionView(){
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().trim().equals("") ||
                        etEmail.getText().toString().trim().equals("") ||
                        etNoHp.getText().toString().trim().equals("") ||
                        etPassword.getText().toString().trim().equals("") ||
                        etRePassword.getText().toString().trim().equals("") ||
                        etEmail.getText().toString().trim().equals("")){
                    showError();
                }
                else if(!etPassword.getText().toString().equals(
                        etRePassword.getText().toString())){
                    showError();
                }
                else{
                    boolean flagEmail = checkEmail(etEmail.getText().toString());
                    boolean flagPhone = checkPhone(etNoHp.getText().toString());
                    if(flagEmail && flagPhone){
                        presenter.register(etUsername.getText().toString(),
                                            etEmail.getText().toString(),
                                            etPassword.getText().toString(),
                                            etNoHp.getText().toString());
                    }
                    else{
                        showError();
                    }
                }
            }
        });
        hideLoading();
    }

    private boolean checkEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean checkPhone(String phone){
        return Patterns.PHONE.matcher(phone).matches();
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Isi Field yang kosong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actionRegisterSuccess(Integer id) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("idUser", id);
        startActivity(intent);
        finish();
    }

    @Override
    public void actionRegisterFailed() {
        Toast.makeText(this,"Register Failed", Toast.LENGTH_SHORT).show();
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