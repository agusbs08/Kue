package com.marketplace.kelompok2.kue.ui.home.fragmentsearch;

import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.base.BasePresenterNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter extends BasePresenterNetwork{
    private SearchView view;
    private Call<DataResponse<Resep>> result;

    public SearchPresenter(SearchView view){
        super();
        this.view = view;
    }

    public void getListResepFromKeyword(final String keyword){
        view.showLoading();
        result = super.service.getListResep();

        result.enqueue(new Callback<DataResponse<Resep>>() {
            @Override
            public void onResponse(Call<DataResponse<Resep>> call, Response<DataResponse<Resep>> response) {
                view.hideLoading();
                ArrayList<Resep> listResep = response.body().getListData();
                view.showListSearch(listResep, keyword);
            }

            @Override
            public void onFailure(Call<DataResponse<Resep>> call, Throwable t) {
                view.hideLoading();
            }
        });
    }
}
