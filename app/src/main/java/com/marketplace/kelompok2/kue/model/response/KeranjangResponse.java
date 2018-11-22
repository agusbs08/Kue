package com.marketplace.kelompok2.kue.model.response;

import com.google.gson.annotations.SerializedName;
import com.marketplace.kelompok2.kue.model.Keranjang;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;

import java.io.Serializable;
import java.util.ArrayList;

public class KeranjangResponse implements Serializable{
    @SerializedName("keranjang")
    private Keranjang keranjang;

    @SerializedName("data")
    private ArrayList<KeranjangList> listKeranjang;

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public ArrayList<KeranjangList> getListKeranjang() {
        return listKeranjang;
    }

    public void setListKeranjang(ArrayList<KeranjangList> listKeranjang) {
        this.listKeranjang = listKeranjang;
    }
}
