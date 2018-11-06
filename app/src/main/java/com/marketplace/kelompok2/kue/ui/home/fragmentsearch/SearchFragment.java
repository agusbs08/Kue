package com.marketplace.kelompok2.kue.ui.home.fragmentsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Resep;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements SearchView{

    private RecyclerView listEvent;
    private EditText searchEditText;
    private ProgressBar pb;
    private ArrayList<Resep> listResep;
    private SearchPresenter presenter;
    private SearchRecyclerViewAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideLoading();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        init(rootView);
        setSearchEditText();
        return rootView;
    }

    private void init(View rootView){
        listEvent = rootView.findViewById(R.id.rv_fragment_search);
        searchEditText = rootView.findViewById(R.id.et_search_fragment_search);
        pb = rootView.findViewById(R.id.pb_fragment_search);
        listResep = new ArrayList<>();
        adapter = new SearchRecyclerViewAdapter(listResep, getContext());
        presenter = new SearchPresenter(this);
        listEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        listEvent.setAdapter(adapter);
    }

    private void setSearchEditText(){
        searchEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        searchEditText.addTextChangedListener(getTextWatcher());
    }

    private TextWatcher getTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getContext(), s.toString(), Toast.LENGTH_SHORT);
                presenter.getListResepFromKeyword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    @Override
    public void showListSearch(ArrayList<Resep> reseps, String keyword) {
        listResep.clear();
        ArrayList<Resep> dataset = reseps;
        for(int i = 0; i < dataset.size(); i++){
            if(dataset.get(i).getNamaResep().toLowerCase().contains(keyword)){
                Log.d(dataset.get(i).getNamaResep(), keyword);
                listResep.add(dataset.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }
}
