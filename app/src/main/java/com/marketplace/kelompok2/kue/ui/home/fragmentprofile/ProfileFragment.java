package com.marketplace.kelompok2.kue.ui.home.fragmentprofile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Pembeli;

public class ProfileFragment extends Fragment implements ProfileView{

    private TextView namaProfile;
    private TextView telpProfile;
    private TextView emailProfile;
    private TextView alamatProfile;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData(){
        namaProfile.setText(UserState.getInstance().getPembeli().getUsername());
        telpProfile.setText(UserState.getInstance().getPembeli().getNoTlp());
        emailProfile.setText(UserState.getInstance().getPembeli().getEmail());
//        alamatProfile.setText(UserState.getInstance().getPembeli().getAlamat());
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
