package com.marketplace.kelompok2.kue.ui.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Pembeli;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private EditText etNama;
    private EditText etPassword;
    private EditText etRePassword;
    private EditText etEmail;
    private EditText etNoHp;
    private Button btnDaftar;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initComponent();
        initActionView();
    }

    private void initView(){
        etNama = findViewById(R.id.et_nama_register);
        etPassword = findViewById(R.id.et_password_register);
        etRePassword = findViewById(R.id.et_repassword_register);
        etEmail = findViewById(R.id.et_email_register);
        etNoHp = findViewById(R.id.et_nohp_register);
        btnDaftar = findViewById(R.id.btn_daftar_register);
    }

    private void initComponent(){
        presenter = new RegisterPresenter(this);
    }

    private void initActionView(){
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()){
                    Pembeli pembeli = presenter.getPembeli(etEmail.getText().toString());
                    if(pembeli == null){
                        actionRegisterFailed();
                    }
                    else{
                        presenter.register(etNama.getText().toString(),
                                etPassword.getText().toString(),
                                etEmail.getText().toString(),
                                etNoHp.getText().toString());
                    }
                }
            }
        });
    }

    private boolean checkValidation(){
        if(etNama.getText().toString().trim().equals("")
                && etPassword.getText().toString().trim().equals("")
                && etRePassword.getText().toString().trim().equals("")
                && etEmail.getText().toString().trim().equals("")
                && etNoHp.getText().toString().trim().equals("")){
            boolean statePassword = checkPassword(etPassword.getText().toString(), etRePassword.getText().toString());
            boolean stateEmail = checkEmail(etEmail.getText().toString());
            boolean statePhone = checkCellPhone(etNoHp.getText().toString());
            if(statePassword && stateEmail && statePhone){
                return true;
            }
        }
        return false;
    }

    private boolean checkEmail(String target) {
        return (Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean checkCellPhone(String number) {
        return Patterns.PHONE.matcher(number).matches();
    }

    private boolean checkPassword(String password, String rePassword){
        return password.equals(rePassword);
    }

    @Override
    public void actionRegisterSuccess(Integer id) {

    }

    @Override
    public void actionRegisterFailed() {
        Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show();
    }
}
