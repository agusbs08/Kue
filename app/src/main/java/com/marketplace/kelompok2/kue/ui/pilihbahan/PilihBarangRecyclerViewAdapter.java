package com.marketplace.kelompok2.kue.ui.pilihbahan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;

import java.util.ArrayList;

public class PilihBarangRecyclerViewAdapter extends RecyclerView.Adapter<PilihBarangRecyclerViewAdapter.PilihBarangViewHolder> {

    private RadioGroup radioGroup;
    private ArrayList<Barang> listBarang;
    private Context context;

    public PilihBarangRecyclerViewAdapter(RadioGroup radioGroup, ArrayList<Barang> listBarang, Context context){
        this.listBarang = listBarang;
        this.radioGroup = radioGroup;
        this.context = context;
    }

    @NonNull
    @Override
    public PilihBarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PilihBarangViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.list_bahan_item, parent, false), radioGroup, context);
    }

    @Override
    public void onBindViewHolder(@NonNull PilihBarangViewHolder holder, int position) {
        holder.bindItem(listBarang.get(position), position);
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    class PilihBarangViewHolder extends RecyclerView.ViewHolder{
        private TextView hargaBarang;
        private View view;
        private RadioGroup radioGroup;
        private Context context;

        public PilihBarangViewHolder(View view, RadioGroup radioGroup, Context context){
            super(view);
            this.view = view;
            this.radioGroup = radioGroup;
            this.context = context;
            initView();
        }

        private void initView(){
            hargaBarang = view.findViewById(R.id.tv_harga_bahan);
        }

        void bindItem(Barang barang, int position){
            View tmp = radioGroup.getChildAt(position);
                if(tmp == null){
                    hargaBarang.setText(barang.getHarga().toString());
                    RadioButton radioButton = new RadioButton(context);
                    radioButton.setId((position + 1) + 100 );
                    radioButton.setText(barang.getNama());
                    radioButton.setLayoutParams(new LinearLayout
                            .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    if(position == 0){
                        radioButton.setChecked(true);
                    }
                    radioGroup.addView(radioButton);
                }

        }
    }
}
