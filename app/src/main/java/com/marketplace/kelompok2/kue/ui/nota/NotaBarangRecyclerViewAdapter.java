package com.marketplace.kelompok2.kue.ui.nota;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NotaBarangRecyclerViewAdapter extends RecyclerView.Adapter<NotaBarangRecyclerViewAdapter.NotaBarangViewHolder>{

    private ArrayList<BarangKeranjang> listBarang;

    public NotaBarangRecyclerViewAdapter(ArrayList<BarangKeranjang> listBarang){
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public NotaBarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotaBarangViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_checkout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotaBarangViewHolder holder, int position) {
        holder.bindItem(listBarang.get(position));
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    class NotaBarangViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageBarang;
        private TextView namaBarang;
        private TextView hargaBarang;

        public NotaBarangViewHolder(View view){
            super(view);
            initView(view);
        }

        private void initView(View view){
            imageBarang = view.findViewById(R.id.iv_gambaritem_checkout);
            namaBarang = view.findViewById(R.id.tv_namaitem_checkout);
            hargaBarang = view.findViewById(R.id.tv_hargaitem_checkout);
        }

        void bindItem(final BarangKeranjang barangKeranjang){
            Barang barang = barangKeranjang.getBarang();
            Picasso.get().load(BuildConfig.BASE_STORAGE + barang.getGambar()).into(imageBarang);
            namaBarang.setText(barang.getNama());
            hargaBarang.setText(barang.getHarga().toString());
        }
    }
}
