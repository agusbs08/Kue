package com.marketplace.kelompok2.kue.ui.home.fragmentsearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.marketplace.kelompok2.kue.R;

public class SearchFragment extends Fragment {

    private RecyclerView listEvent;
    private EditText searchEditText;

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
    }

    private void setSearchEditText(){
        searchEditText.setFocusable(true);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
