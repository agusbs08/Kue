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

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.KategoriResep;
import com.marketplace.kelompok2.kue.ui.listresepper.ResepKhususActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeKategoriRecyclerViewAdapter extends RecyclerView.Adapter<HomeKategoriRecyclerViewAdapter.HomeKategoriViewHolder>{

    private Context context;
    private ArrayList<KategoriResep> listKategoriResep;

    public HomeKategoriRecyclerViewAdapter(Context context, ArrayList<KategoriResep> listKategoriResep){
        this.context = context;
        this.listKategoriResep = listKategoriResep;
    }

    @NonNull
    @Override
    public HomeKategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeKategoriViewHolder(
                LayoutInflater.from(context).inflate(R.layout.list_kategori_beranda, parent, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeKategoriViewHolder holder, int position) {
        holder.bindItem(listKategoriResep.get(position));
    }

    @Override
    public int getItemCount() {
       return listKategoriResep.size();
    }

    class HomeKategoriViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        private ImageView imageView;
        private TextView textView;

        public HomeKategoriViewHolder(View view, Context context){
            super(view);
            this.context = context;
            initView(view);
        }

        private void initView(View view){
            imageView = view.findViewById(R.id.iv_fotokategori_beranda);
            textView = view.findViewById(R.id.tv_namakategori_beranda);
        }

        void bindItem(final KategoriResep kategoriResep){
            Picasso.get().load(kategoriResep.getImageKategori()).into(imageView);
            textView.setText(kategoriResep.getNamaKategori());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ResepKhususActivity.class);
                    intent.putExtra("key", 0);
                    intent.putExtra("id", kategoriResep.getIdKategori());
                    intent.putExtra("name", kategoriResep.getNamaKategori());
                    context.startActivity(intent);
                }
            });
        }
    }
}
