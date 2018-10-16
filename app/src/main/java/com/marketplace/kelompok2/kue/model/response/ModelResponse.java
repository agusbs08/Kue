package com.marketplace.kelompok2.kue.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.marketplace.kelompok2.kue.model.Pembeli;

public class ModelResponse<MODEL> {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private MODEL model;

    public ModelResponse(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MODEL getModel() {
        return model;
    }

    public void setModel(MODEL model) {
        this.model = model;
    }
}
