package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marketplace.kelompok2.kue.R;

public class PesananRecyclerViewAdapter extends RecyclerView.Adapter<PesananRecyclerViewAdapter.PesananViewHolder> {

    @NonNull
    @Override
    public PesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PesananViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.daftar_pesanan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PesananViewHolder holder, int position) {
        holder.bindItem();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PesananViewHolder extends RecyclerView.ViewHolder{

        public PesananViewHolder(View view){
            super(view);
        }

        void bindItem(){

        }
    }
}
