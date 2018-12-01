package com.marketplace.kelompok2.kue.ui.editprofil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;

public class EditProfilActivity extends AppCompatActivity implements EditProfilView {

    private ImageButton imgUser;
    private EditText namaUser;
    private EditText emailUser;
    private EditText nomerUser;
    private EditText alamatUser;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_editprofile);
        initView();
        initData();
    }

    private void initData(){
        namaUser.setText(UserState.getInstance().getPembeli().getUsername());
        emailUser.setText(UserState.getInstance().getPembeli().getEmail());
        nomerUser.setText(UserState.getInstance().getPembeli().getNoTlp());
    }

    private void initView(){
        imgUser = findViewById(R.id.ib_photo_editprofile);
        namaUser = findViewById(R.id.et_namapemilik_editprofile);
        emailUser = findViewById(R.id.et_email_editprofile);
        nomerUser =findViewById(R.id.et_nomor_editprofile);
        alamatUser = findViewById(R.id.et_alamat_editprofile);
        btnSimpan = findViewById(R.id.btn_simpan_editprofile);
        initBtn();
    }

    private void initBtn(){
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO addPresenterActionUpdateMethod
            }
        });
    }

    @Override
    public void actionSuccessUpdate() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
