package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.KategoriResep;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.ui.home.HomeSearchView;
import com.marketplace.kelompok2.kue.ui.listresepper.ResepKhususActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeView {

    private EditText searchView;
    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter adapter;
    private ArrayList<Resep> listResep;
    private ArrayList<KategoriResep> listKategoriResep;
    private ProgressBar progressBar;
    private HomePresenter presenter;

    private RecyclerView recyclerViewKategori;
    private HomeKategoriRecyclerViewAdapter kategoriAdapter;

    private CarouselView carouselView;

    private int[] listChef = {R.drawable.juna, R.drawable.chandra};
    private int[] idChef = {1,2};
    private String[] chefName = {"Juna", "Chandra"};
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
        View rootView = inflater.inflate(R.layout.fragment_berandabaru, container, false);
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
        recyclerViewKategori = rootView.findViewById(R.id.list_kategori_beranda);
        carouselView = rootView.findViewById(R.id.carv_1);
        initCarousel();
    }

    private void initCarousel(){
        carouselView.setPageCount(listChef.length);
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(listChef[position]);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), ResepKhususActivity.class);
                        intent.putExtra("key", 1);
                        intent.putExtra("id",idChef[position]);
                        intent.putExtra("name", chefName[position]);
                        startActivity(intent);
                    }
                });

            }
        };
        carouselView.setImageListener(imageListener);
    }

    private void initComponent(){
        listResep = new ArrayList<>();
        listKategoriResep = new ArrayList<>();

        adapter = new HomeRecyclerViewAdapter(getContext(), listResep);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        kategoriAdapter = new HomeKategoriRecyclerViewAdapter(getContext(), listKategoriResep);
        recyclerViewKategori.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerViewKategori.setAdapter(kategoriAdapter);
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
    public void showListResep(ArrayList<Resep> listResep, ArrayList<KategoriResep> listKategoriResep) {
        this.listResep.clear();
        this.listKategoriResep.clear();
        this.listResep.addAll(listResep);
        this.listKategoriResep.addAll(listKategoriResep);
        adapter.notifyDataSetChanged();
        kategoriAdapter.notifyDataSetChanged();
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
