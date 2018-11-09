package com.marketplace.kelompok2.kue.common;

import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.model.Penjual;

public class UserState {
    private static UserState instance = null;

    private Integer idUser;
    private Pembeli pembeli;
    private Penjual penjual;

    private UserState(){
        init();
    }

    private void init(){
        idUser = 0;
    }

    public static UserState getInstance(){
        if(instance == null){
            instance = new UserState();
        }
        return instance;
    }

    public Pembeli getPembeli() {
        return this.pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }
}
