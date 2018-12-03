package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

public class Chef {

    @SerializedName("id_chef")
    private Integer idChef;

    @SerializedName("nama_chef")
    private String namaChef;

    public Integer getIdChef() {
        return idChef;
    }

    public void setIdChef(Integer idChef) {
        this.idChef = idChef;
    }

    public String getNamaChef() {
        return namaChef;
    }

    public void setNamaChef(String namaChef) {
        this.namaChef = namaChef;
    }
}
