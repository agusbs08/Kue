package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class ResepFavorit {
    @SerializedName("resep")
    private Resep resep;

    @SerializedName("id_favorit")
    private Integer idFavorit;

    public ResepFavorit(){

    }

    public Resep getResep() {
        return resep;
    }

    public void setResep(Resep resep) {
        this.resep = resep;
    }

    public Integer getIdFavorit() {
        return idFavorit;
    }

    public void setIdFavorit(Integer idFavorit) {
        this.idFavorit = idFavorit;
    }
}
