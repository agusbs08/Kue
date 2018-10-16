package com.marketplace.kelompok2.kue.ui.resep;

import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;
import retrofit2.Call;
public class ResepPresenter extends BasePresenterNetwork{

    private Call<DataResponse<Resep>> result;
    private ResepView view;

    public ResepPresenter(ResepView view){
        super();
        this.view = view;
    }

    public void getResep(Integer id){

    }
}
