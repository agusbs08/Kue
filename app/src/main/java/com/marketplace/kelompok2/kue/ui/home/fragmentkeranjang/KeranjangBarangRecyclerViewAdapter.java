package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.content.Context;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KeranjangBarangRecyclerViewAdapter extends RecyclerView.Adapter<KeranjangBarangRecyclerViewAdapter.KeranjangBarangViewHolder>{

    private ArrayList<BarangKeranjang> listPesanan;

    public KeranjangBarangRecyclerViewAdapter(ArrayList<BarangKeranjang> listPesanan){
        this.listPesanan = listPesanan;
    }

    @NonNull
    @Override
    public KeranjangBarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KeranjangBarangViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_keranjang, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangBarangViewHolder holder, int position) {
        holder.bindItem(listPesanan.get(position));
    }

    @Override
    public int getItemCount() {
        return listPesanan.size();
    }

    class KeranjangBarangViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private ImageView imageView;
        private TextView namaPesanan;
        private TextView hargaPesanan;

        public KeranjangBarangViewHolder(View view){
            super(view);
            this.view = view;
            initView(view);
        }

        private void initView(View view){
            imageView = view.findViewById(R.id.iv_foto_keranjang);
            namaPesanan = view.findViewById(R.id.tv_namaitem_pesanan);
            hargaPesanan = view.findViewById(R.id.tv_harga_keranjang);
        }

        public void bindItem(BarangKeranjang barangKeranjang){
            Barang barang = barangKeranjang.getBarang();
            Picasso.get().load(BuildConfig.BASE_STORAGE + barang.getGambar()).into(imageView);
            namaPesanan.setText(barang.getNama());
            hargaPesanan.setText(barang.getHarga().toString());
        }
    }
}
