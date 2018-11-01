package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.ui.home.HomeSearchView;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeView {

    private EditText searchView;
    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter adapter;
    private ArrayList<Resep> listResep;
    private ProgressBar progressBar;
    private HomePresenter presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getListResep();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        initComponent();
        setSearchView();
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initView(View rootView){
        searchView = rootView.findViewById(R.id.et_search_fragment_home);
        recyclerView = rootView.findViewById(R.id.recyclerview_fragment_home);
        progressBar = rootView.findViewById(R.id.pb_fragment_home);
    }

    private void initComponent(){
        listResep = new ArrayList<>();
        adapter = new HomeRecyclerViewAdapter(getContext(), listResep);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        presenter = new HomePresenter(this);
    }

    private void setSearchView(){
        searchView.setFocusable(false);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeSearchView view = (HomeSearchView)getActivity();
                view.setSearchFragment();
            }
        });
    }

    @Override
    public void showListResep(ArrayList<Resep> listResep) {
        this.listResep.addAll(listResep);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), "Error Get Data", Toast.LENGTH_SHORT);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
