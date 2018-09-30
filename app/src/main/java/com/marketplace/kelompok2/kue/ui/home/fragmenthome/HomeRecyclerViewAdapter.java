package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marketplace.kelompok2.kue.BerhasilActivity;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;

import java.util.ArrayList;


public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder> {

    private Context context;
    private ArrayList<Barang> listBarang;

    public HomeRecyclerViewAdapter(Context context, ArrayList<Barang> listBarang){
        this.context = context;
        this.listBarang = listBarang;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageItem;
        private RatingBar ratingItem;
        private TextView namaItem ;

        public HomeViewHolder(View view){
            super(view);
            imageItem = (ImageView)view.findViewById(R.id.img_list_item);
            ratingItem = (RatingBar)view.findViewById(R.id.rating_list_item);
            namaItem = (TextView)view.findViewById(R.id.tv_nama_item);
        }

        public void bindItem(Barang barang){
            Glide.with(imageItem).load(barang.getGambar());
            ratingItem.setRating(barang.getRating());
            namaItem.setText(barang.getNama());
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bindItem(listBarang.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BerhasilActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
       return listBarang.size();
    }

}
