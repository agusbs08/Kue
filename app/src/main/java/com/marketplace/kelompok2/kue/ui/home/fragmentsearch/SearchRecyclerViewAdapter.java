package com.marketplace.kelompok2.kue.ui.home.fragmentsearch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.ui.resep.ResepActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.SearchViewHolder> {

    private ArrayList<Resep> listResep;
    private Context context;

    public SearchRecyclerViewAdapter(ArrayList<Resep> listResep, Context context){
        this.listResep = listResep;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_search, parent, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bindItem(listResep.get(position));
    }

    @Override
    public int getItemCount() {
        return listResep.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private Context context;

        private TextView namaResep;
        private ImageView imageResep;

        public SearchViewHolder(View view, Context context){
            super(view);
            this.view = view;
            this.context = context;
            initView(view);
        }

        private void initView(View view){
            namaResep = view.findViewById(R.id.tv_list_resep_list_search);
            imageResep = view.findViewById(R.id.img_list_resep_list_search);
        }

        public void bindItem(final Resep resep){
            Picasso.get().load(resep.getImageResep()).into(imageResep);
            namaResep.setText(resep.getNamaResep());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ResepActivity.class);
                    intent.putExtra("idResep", resep.getId());
                    intent.putExtra("namaResep", resep.getNamaResep());
                    intent.putExtra("caraResep", resep.getListCara());
                    intent.putExtra("bahanResep", resep.getListBahan());
                    intent.putExtra("imageResep", resep.getImageResep());
                    context.startActivity(intent);
                }
            });
        }
    }
}
