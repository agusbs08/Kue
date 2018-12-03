package com.marketplace.kelompok2.kue.ui.listresepper;

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
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.ui.resep.ResepActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ResepKhususRecyclerViewAdapter extends RecyclerView.Adapter<ResepKhususRecyclerViewAdapter.ResepKhususViewHolder> {

    private ArrayList<Resep> listResep;
    private Context context;
    public ResepKhususRecyclerViewAdapter(ArrayList<Resep> listResep, Context context){
        this.listResep = listResep;
        this.context = context;
    }

    @NonNull
    @Override
    public ResepKhususViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResepKhususViewHolder(LayoutInflater.from(context).inflate(R.layout.list_beranda, parent, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull ResepKhususViewHolder holder, int position) {
        holder.bindItem(listResep.get(position));
    }

    @Override
    public int getItemCount() {
        return listResep.size();
    }

    class ResepKhususViewHolder extends RecyclerView.ViewHolder{

        private Context context;
        private ImageView imageResep;
        private TextView namaResep ;
        private TextView authorResep;

        public ResepKhususViewHolder(View view, Context context){
            super(view);
            this.context = context;
            initView(view);
        }

        private void initView(View view){
            namaResep = view.findViewById(R.id.tv_namaproduk_list_beranda);
            imageResep = view.findViewById(R.id.img_produk_list_beranda);
            authorResep = view.findViewById(R.id.tv_author_list_beranda);
        }

        void bindItem(Resep resep){
            Picasso.get().load(resep.getImageResep()).into(imageResep);
            namaResep.setText(resep.getNamaResep());
            authorResep.setText(resep.getChef().getNamaChef());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ResepActivity.class);
                    intent.putExtra("idResep", resep.getId());
                    intent.putExtra("namaResep", resep.getNamaResep());
                    intent.putExtra("caraResep", resep.getListCara());
                    intent.putExtra("bahanResep", resep.getListBahan());
                    intent.putExtra("imageResep", resep.getImageResep());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
