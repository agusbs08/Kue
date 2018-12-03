package com.marketplace.kelompok2.kue.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Resep implements Serializable{
    @SerializedName("id_resep")
    private Integer id;

    @SerializedName("nama_resep")
    private String namaResep;

    @SerializedName("bahan")
    private String listBahan;

    @SerializedName("cara")
    private String listCara;

    @SerializedName("image_resep")
    private String imageResep;

    @SerializedName("chef")
    private Chef chef;

    public Resep(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaResep() {
        return namaResep;
    }

    public void setNamaResep(String namaResep) {
        this.namaResep = namaResep;
    }

    public String getListBahan() {
        return listBahan;
    }

    public void setListBahan(String listBahan) {
        this.listBahan = listBahan;
    }

    public String getListCara() {
        return listCara;
    }

    public void setListCara(String listCara) {
        this.listCara = listCara;
    }

    public String getImageResep() {
        return imageResep;
    }

    public void setImageResep(String imageResep) {
        this.imageResep = imageResep;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
}
