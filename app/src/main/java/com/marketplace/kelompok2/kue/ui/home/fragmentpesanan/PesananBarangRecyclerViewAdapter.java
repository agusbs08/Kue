package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

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
import com.marketplace.kelompok2.kue.model.BarangTransaksi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PesananBarangRecyclerViewAdapter extends RecyclerView.Adapter<PesananBarangRecyclerViewAdapter.PesananBarangViewHolder> {

    private ArrayList<BarangTransaksi> listPesanan;
    private Context context;

    public PesananBarangRecyclerViewAdapter(Context context, ArrayList<BarangTransaksi> listPesanan){
        this.context = context;
        this.listPesanan = listPesanan;
    }

    @NonNull
    @Override
    public PesananBarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PesananBarangViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_pesanan, parent, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananBarangViewHolder holder, int position) {
        holder.bindItem(listPesanan.get(position));
    }

    @Override
    public int getItemCount() {
        return listPesanan.size();
    }

    class PesananBarangViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private Context context;
        private ImageView imageView;
        private TextView namaPesanan;
        private TextView hargaPesanan;

        public PesananBarangViewHolder(View view, Context context){
            super(view);
            this.view = view;
            this.context = context;
            initView(view);
        }

        private void initView(View view){
            imageView = view.findViewById(R.id.iv_foto_pesanan);
            namaPesanan = view.findViewById(R.id.tv_namaitem_pesanan);
            hargaPesanan = view.findViewById(R.id.tv_harga_pesanan);
        }

        public void bindItem(BarangTransaksi barangTransaksi){
            Barang barang = barangTransaksi.getBarang();
            Picasso.get().load(BuildConfig.BASE_STORAGE + barang.getGambar()).into(imageView);
            namaPesanan.setText(barang.getNama());
            hargaPesanan.setText(barang.getHarga().toString());
        }
    }
}
