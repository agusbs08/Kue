package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marketplace.kelompok2.kue.R;

public class HomeFragment extends Fragment {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context context;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        init(rootView);
        setToolbar();
        setViewPager();
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

    private void init(View rootView){
        toolbar = rootView.findViewById(R.id.toolbar_fragment_home);
        viewPager = rootView.findViewById(R.id.view_pager_fragment_home);
        tabLayout = rootView.findViewById(R.id.tab_layout_fragment_home);
        context = getContext();
    }

    private void setToolbar(){
        if(toolbar != null){
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
            //((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(toolbar);
        }
    }

    private void setViewPager(){
        ViewPagerAdapterFragmentHome viewPagerAdapterFragmentHome =
                new ViewPagerAdapterFragmentHome(getChildFragmentManager(),context);
        viewPager.setAdapter(viewPagerAdapterFragmentHome);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
