package com.marketplace.kelompok2.kue.ui.home.fragmenthome;

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


public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder> {

    private Context context;
    private ArrayList<Resep> listResep;

    public HomeRecyclerViewAdapter(Context context, ArrayList<Resep> listResep){
        this.context = context;
        this.listResep = listResep;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private Context ctx;
        private ImageView imageResep;
        private TextView namaResep ;

        HomeViewHolder(View view, Context context){
            super(view);
            this.ctx = context;
            initView(view);
        }

        private void initView(View view){
            namaResep = view.findViewById(R.id.tv_namaproduk_list_beranda);
            imageResep = view.findViewById(R.id.img_produk_list_beranda);
        }

        void bindItem(final Resep resep){
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
                    ctx.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_beranda, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {
        holder.bindItem(listResep.get(position));
    }

    @Override
    public int getItemCount() {
       return listResep.size();
    }

}
