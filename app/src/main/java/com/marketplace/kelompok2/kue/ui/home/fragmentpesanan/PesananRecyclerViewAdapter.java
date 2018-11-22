package com.marketplace.kelompok2.kue.ui.home.fragmentpesanan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.list.BarangTransaksiList;

import java.util.ArrayList;

public class PesananRecyclerViewAdapter extends RecyclerView.Adapter<PesananRecyclerViewAdapter.PesananViewHolder> {

    private ArrayList<BarangTransaksiList> barangTransaksiLists;
    private Context context;

    public PesananRecyclerViewAdapter(ArrayList<BarangTransaksiList> barangTransaksiLists, Context context){
        this.barangTransaksiLists = barangTransaksiLists;
        this.context = context;
    }

    @NonNull
    @Override
    public PesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PesananViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.daftar_pesanan, parent, false),context);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananViewHolder holder, int position) {
        holder.bindItem(barangTransaksiLists.get(position));
    }

    @Override
    public int getItemCount() {
        return barangTransaksiLists.size();
    }

    class PesananViewHolder extends RecyclerView.ViewHolder{

        private TextView namaToko;
        private TextView noPesanan;
        private TextView totalHargaPesanan;
        private TextView statusPesanan;
        private RecyclerView recyclerView;
        private PesananBarangRecyclerViewAdapter adapter;
        private Context context;

        public PesananViewHolder(View view, Context context){
            super(view);
            this.context = context;
            initView(view);
        }

        private void initView(View view){
            noPesanan = view.findViewById(R.id.no_pesanan);
            namaToko = view.findViewById(R.id.tv_namatoko_nota);
            totalHargaPesanan = view.findViewById(R.id.tv_totalharga);
            statusPesanan = view.findViewById(R.id.tv_status_pesanan);
            recyclerView = view.findViewById(R.id.rv_listbarang_nota);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        void bindItem(BarangTransaksiList barangTransaksiList){
            namaToko.setText(barangTransaksiList.getPenjual().getNamatoko());
            noPesanan.setText(barangTransaksiList.getDetailTransaksi().getId().toString());
            statusPesanan.setText(barangTransaksiList.getDetailTransaksi().getStatusProses());
            totalHargaPesanan.setText(getTotalHarga(barangTransaksiList.getListBarang()));
            if(adapter == null){
                adapter = new PesananBarangRecyclerViewAdapter(context,barangTransaksiList.getListBarang());
                recyclerView.setAdapter(adapter);
            }
        }

        private String getTotalHarga(ArrayList<Barang> listBarang){
            Float total = new Float(0);
            for(Barang barang : listBarang){
                total += barang.getHarga();
            }
            Integer harga = total.intValue();
            return harga.toString();
        }
    }
}
