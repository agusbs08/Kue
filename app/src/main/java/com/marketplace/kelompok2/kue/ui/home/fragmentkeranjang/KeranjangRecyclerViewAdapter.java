package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Keranjang;

import java.util.ArrayList;

public class KeranjangRecyclerViewAdapter extends RecyclerView.Adapter<KeranjangRecyclerViewAdapter.KeranjangViewHolder>{

    private Context context;
    private ArrayList<Keranjang> listKeranjang;

    public KeranjangRecyclerViewAdapter(Context context, ArrayList<Keranjang> listKeranjang){
        this.context = context;
        this.listKeranjang = listKeranjang;
    }

    @NonNull
    @Override
    public KeranjangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KeranjangViewHolder(LayoutInflater.from(context).
                inflate(R.layout.daftar_keranjang , parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangViewHolder holder, int position) {
        holder.bindItem(listKeranjang.get(position));
    }

    @Override
    public int getItemCount() {
        return listKeranjang.size();
    }

    public class KeranjangViewHolder extends RecyclerView.ViewHolder{
        private TextView namaKeranjang;


        public KeranjangViewHolder(View view) {
            super(view);
        }

        public void bindItem(Keranjang keranjang){

        }
    }
}
