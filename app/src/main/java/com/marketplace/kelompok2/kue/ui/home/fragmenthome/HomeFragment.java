package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.HomeSearchView;

public class HomeFragment extends Fragment {

    private EditText searchView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context context;
    private ViewPagerAdapterFragmentHome adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        init(rootView);
        setSearchView();
        setViewPager();
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void init(View rootView){
        searchView = rootView.findViewById(R.id.et_search_fragment_home);
        viewPager = rootView.findViewById(R.id.view_pager_fragment_home);
        tabLayout = rootView.findViewById(R.id.tab_layout_fragment_home);
        context = getContext();
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

    private void setViewPager(){
        adapter = new ViewPagerAdapterFragmentHome(getChildFragmentManager(),context);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}
