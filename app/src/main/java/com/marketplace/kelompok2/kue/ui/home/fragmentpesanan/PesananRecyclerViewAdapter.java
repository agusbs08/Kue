package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Pesanan;

import java.util.ArrayList;

public class PesananRecyclerViewAdapter extends RecyclerView.Adapter<PesananRecyclerViewAdapter.PesananViewHolder> {

    private ArrayList<Pesanan> listPesanan;
    private Context context;

    public PesananRecyclerViewAdapter(Context context, ArrayList<Pesanan> listPesanan){
        this.context = context;
        this.listPesanan = listPesanan;
    }

    @NonNull
    @Override
    public PesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PesananViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.daftar_pesanan, parent, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananViewHolder holder, int position) {
        holder.bindItem(listPesanan.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PesananViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private Context context;
        public PesananViewHolder(View view, Context context){
            super(view);
            this.view = view;
        }

        public void bindItem(Pesanan pesanan){

        }
    }
}
