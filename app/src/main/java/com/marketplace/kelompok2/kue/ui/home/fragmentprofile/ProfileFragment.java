package com.marketplace.kelompok2.kue.ui.home.fragmentprofile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.ui.PrefManager;
import com.marketplace.kelompok2.kue.ui.editprofil.EditProfilActivity;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.marketplace.kelompok2.kue.ui.login.LoginActivity;
import com.marketplace.kelompok2.kue.ui.pilihbahan.PilihBahanView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements ProfileView{

    private TextView namaProfile;
    private TextView telpProfile;
    private TextView emailProfile;
    private TextView alamatProfile;
    private TextView statusLogin;
    private CircleImageView imageView;

    private Button btnEdit;
    private Button btnLoginLogout;
    private boolean loginState;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginState = false;
        if(UserState.getInstance().getPembeli() == null){
            statusLogin.setVisibility(View.VISIBLE);
            btnLoginLogout.setText("Login");
        }
        else{
            loginState = true;
            initData();
        }
        initBtn();
    }

    private void initData(){
        if(UserState.getInstance().getPembeli().getNama() == null){
            namaProfile.setText(UserState.getInstance().getPembeli().getUsername());
        }
        else{
            namaProfile.setText(UserState.getInstance().getPembeli().getNama());
        }
        telpProfile.setText(UserState.getInstance().getPembeli().getNoTlp());
        emailProfile.setText(UserState.getInstance().getPembeli().getEmail());
//        alamatProfile.setText(UserState.getInstance().getPembeli().getAlamat());
        if(UserState.getInstance().getPembeli().getGambarPembeli() != null){
            Picasso.get().load(UserState.getInstance().getPembeli().getGambarPembeli()).into(imageView);
        }
    }

    private void initBtn(){
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginState){
                    Intent intent = new Intent(getContext(), EditProfilActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(), "Anda Belum Login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoginLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginState){
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("frompenjual");
                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    startActivity(intent);
                    PrefManager pref = new PrefManager(getContext());
                    pref.setUser(0,null);
                    UserState.getInstance().setPembeli(null);
                    UserState.getInstance().setIdUser(0);
                    getActivity().finish();
                }
                else{
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view){
        namaProfile = view.findViewById(R.id.tv_nama_profile);
        telpProfile = view.findViewById(R.id.tv_telp_profile);
        emailProfile = view.findViewById(R.id.tv_email_profile);
        alamatProfile = view.findViewById(R.id.tv_alamat_profile);
        btnEdit = view.findViewById(R.id.btn_edit_profile);
        btnLoginLogout = view.findViewById(R.id.btn_logout_profile);
        statusLogin = view.findViewById(R.id.tv_status_login);
        imageView = view.findViewById(R.id.circleImageView2);
    }

    @Override
    public void showProfile(Pembeli pembeli) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
