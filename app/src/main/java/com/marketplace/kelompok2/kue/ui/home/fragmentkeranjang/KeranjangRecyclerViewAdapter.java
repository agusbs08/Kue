package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

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
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.marketplace.kelompok2.kue.model.list.KeranjangList;

import java.util.ArrayList;

public class KeranjangRecyclerViewAdapter extends RecyclerView.Adapter<KeranjangRecyclerViewAdapter.KeranjangViewHolder> {

    private Context context;
    private ArrayList<KeranjangList> listKeranjang;

    public KeranjangRecyclerViewAdapter(Context context, ArrayList<KeranjangList> listKeranjang){
        this.context = context;
        this.listKeranjang = listKeranjang;
    }

    @NonNull
    @Override
    public KeranjangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KeranjangViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_keranjang, parent, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangViewHolder holder, int position) {
        holder.bindItem(listKeranjang.get(position));
    }

    @Override
    public int getItemCount() {
        return listKeranjang.size();
    }

    class KeranjangViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        private TextView namaToko;
        private TextView totalHarga;
        private RecyclerView recyclerView;
        private KeranjangBarangRecyclerViewAdapter adapter;

        private Float hargaTotal;

        public KeranjangViewHolder(View view, Context context){
            super(view);
            this.context = context;
            initView(view);
        }

        private void initView(View rootView){
            namaToko = rootView.findViewById(R.id.tv_namatoko_keranjang);
            totalHarga = rootView.findViewById(R.id.tv_totalharga_keranjang);
            recyclerView = rootView.findViewById(R.id.rv_listbarang_keranjang);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        void bindItem(KeranjangList keranjangList){
            if(adapter == null){
                hargaTotal = Float.parseFloat(getHargaTotal(keranjangList.getListBarang()));
                adapter = new KeranjangBarangRecyclerViewAdapter(keranjangList.getListBarang(), hargaTotal, totalHarga);
                recyclerView.setAdapter(adapter);
                namaToko.setText(keranjangList.getPenjual().getNamatoko());
                totalHarga.setText(" ");
            }
        }

        private String getHargaTotal(ArrayList<BarangKeranjang> listBarang){
            Float total = new Float(0);
            for(BarangKeranjang barangKeranjang : listBarang){
                Barang barang = barangKeranjang.getBarang();
                total += barang.getHarga();
            }
            Integer harga = total.intValue();
            return harga.toString();
        }

    }
}
