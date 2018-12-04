package com.marketplace.kelompok2.kue.ui.home.fragmentkeranjang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangKeranjang;
import com.squareup.picasso.Picasso;

import java.nio.channels.FileLock;
import java.util.ArrayList;

public class KeranjangBarangRecyclerViewAdapter extends RecyclerView.Adapter<KeranjangBarangRecyclerViewAdapter.KeranjangBarangViewHolder>{

    private ArrayList<BarangKeranjang> listPesanan;
    private Float hargaTotal;
    private TextView totalHarga;
    public KeranjangBarangRecyclerViewAdapter(ArrayList<BarangKeranjang> listPesanan, Float hargaTotal, TextView totalHarga){
        this.listPesanan = listPesanan;
        this.hargaTotal = hargaTotal;
        this.totalHarga = totalHarga;
    }

    @NonNull
    @Override
    public KeranjangBarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KeranjangBarangViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_keranjang, parent,false),
                hargaTotal,totalHarga);
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

        private Button btnTambah;
        private Button btnKurang;
        private TextView tvJumlah;

        private Integer jumlah = -1;

        private Float hargaTotal;
        private TextView totalHarga;
        public KeranjangBarangViewHolder(View view, Float hargaTotal, TextView totalHarga){
            super(view);
            this.view = view;
            this.hargaTotal = hargaTotal;
            this.totalHarga = totalHarga;
            initView(view);
        }

        private void initView(View view){
            imageView = view.findViewById(R.id.iv_foto_keranjang);
            namaPesanan = view.findViewById(R.id.tv_namaitem_pesanan);
            hargaPesanan = view.findViewById(R.id.tv_harga_keranjang);
            btnTambah = view.findViewById(R.id.btn_tambahitem_keranjang);
            btnKurang = view.findViewById(R.id.btn_kurangitem_keranjang);
            tvJumlah = view.findViewById(R.id.tv_jumlahitem_keranjang);
        }

        public void bindItem(BarangKeranjang barangKeranjang){
            Barang barang = barangKeranjang.getBarang();
            Picasso.get().load(BuildConfig.BASE_STORAGE + barang.getGambar()).into(imageView);
            namaPesanan.setText(barang.getNama());
            hargaPesanan.setText(barang.getHarga().toString());
            if(jumlah == -1){
                jumlah = barangKeranjang.getKuantitas();
            }
            tvJumlah.setText(jumlah.toString());
            barang.setKuantitasKeranjang(jumlah);
            initBtn(barang);
        }

        private void initBtn(Barang barang){
            btnTambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int state = jumlah;
                    jumlah+=1;
                    updateJumlah(barang, state);
                }
            });

            btnKurang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int state = jumlah;
                    if(jumlah > 1){
                        jumlah-=1;
                    }
                    updateJumlah(barang, state);
                }
            });
        }

        private void updateJumlah(Barang barang, int state){
            tvJumlah.setText(jumlah.toString());
            barang.setKuantitasKeranjang(jumlah);
            Float hargaSebelum = barang.getHarga() * state;
            Float hargaSesudah = barang.getHarga() *jumlah;
            hargaTotal = hargaTotal - hargaSebelum + hargaSesudah;
            totalHarga.setText(" ");
        }
    }
}
