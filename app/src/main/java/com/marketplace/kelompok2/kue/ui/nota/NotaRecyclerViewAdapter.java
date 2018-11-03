package com.marketplace.kelompok2.kue.ui.nota;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.squareup.picasso.Picasso;

public class NotaRecyclerViewAdapter extends RecyclerView.Adapter<NotaRecyclerViewAdapter.NotaViewHolder>{

    private BarangList listBarang;
    private Context context;

    public NotaRecyclerViewAdapter(BarangList listBarang, Context context){
        this.listBarang = listBarang;
        this.context = context;
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_checkout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {
        holder.bindItem(listBarang.getListBarang().get(position));
    }

    @Override
    public int getItemCount() {
        return listBarang.getListBarang().size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageBarang;
        private TextView namaBarang;
        private TextView hargaBarang;

        public NotaViewHolder(View view){
            super(view);
            initView(view);
        }

        private void initView(View view){
            imageBarang = view.findViewById(R.id.iv_gambaritem_checkout);
            namaBarang = view.findViewById(R.id.tv_namaitem_checkout);
            hargaBarang = view.findViewById(R.id.tv_hargaitem_checkout);
        }

        void bindItem(final Barang barang){
            Picasso.get().load(BuildConfig.BASE_STORAGE + barang.getGambar()).into(imageBarang);
            namaBarang.setText(barang.getNama());
            hargaBarang.setText(barang.getHarga().toString());
        }
    }
}
