package com.marketplace.kelompok2.kue.ui.nota;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;

import java.util.ArrayList;

public class NotaRecyclerViewAdapter extends RecyclerView.Adapter<NotaRecyclerViewAdapter.NotaViewHolder> {

    private ArrayList<KeranjangList> listKeranjang;

    public NotaRecyclerViewAdapter(ArrayList<KeranjangList> listKeranjang){
        this.listKeranjang = listKeranjang;
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_checkout, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {
        holder.bindItem(listKeranjang.get(position));
    }

    @Override
    public int getItemCount() {
        return listKeranjang.size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView recyclerView;
        private TextView namaToko;
        private NotaBarangRecyclerViewAdapter adapter;
        private Context context;

        public NotaViewHolder(View view, Context context){
            super(view);
            this.context = context;
            initView(view);
        }

        private void initView(View view){
            namaToko = view.findViewById(R.id.tv_namatoko_checkout);
            recyclerView = view.findViewById(R.id.rv_listchekout);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        void bindItem(KeranjangList keranjangList){
            if(adapter == null){
                adapter = new NotaBarangRecyclerViewAdapter(keranjangList.getListBarang());
                recyclerView.setAdapter(adapter);
                namaToko.setText("Toko: " + keranjangList.getPenjual().getNamatoko());
            }
        }

    }
}
