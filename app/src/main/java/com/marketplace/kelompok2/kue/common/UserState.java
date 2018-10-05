package com.marketplace.kelompok2.kue.common;

public class UserState {
    private static UserState instance = null;

    private Integer idUser;
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
