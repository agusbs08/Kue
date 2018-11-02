package com.marketplace.kelompok2.kue.ui.pilihbahan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangTokoList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PilihBahanRecyclerViewAdapter extends RecyclerView.Adapter<PilihBahanRecyclerViewAdapter.PilihBahanViewHolder> {

    private ArrayList<BarangTokoList> listBarangToko;
    private Context context;
    ArrayList<PilihBahanViewHolder> listViewHolder;

    public PilihBahanRecyclerViewAdapter(ArrayList<BarangTokoList> listBarangToko, Context context, ArrayList<PilihBahanViewHolder> listViewHolder){
        this.listBarangToko = listBarangToko;
        this.context = context;
        this.listViewHolder = listViewHolder;
    }

    @NonNull
    @Override
    public PilihBahanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PilihBahanViewHolder viewHolder = new PilihBahanViewHolder(LayoutInflater
                .from(context).inflate(R.layout.list_bahan, parent, false),
                context);
        listViewHolder.add(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PilihBahanViewHolder holder, int position) {
        holder.bindItem(listBarangToko.get(0), position, listBarangToko.get(0).getKeywords().get(position));
    }

    @Override
    public int getItemCount() {
        return listBarangToko.get(0).getKeywords().size();
    }

    class PilihBahanViewHolder extends RecyclerView.ViewHolder implements PilihBahanViewHolderView{
        private TextView namaBahan;
        private CheckBox checkBoxBahan;
        private RadioGroup radioGroupListBahan;
        private Context context;
        private Integer rbSelectedId;
        private View view;
        private LinearLayout layoutListHarga;
        private LinearLayout layout;

        public PilihBahanViewHolder(View view, Context context){
            super(view);
            this.context = context;
            this.view = view;
            initView();
        }

        private void initView(){
            namaBahan = view.findViewById(R.id.tv_namabahan_bahan);
            checkBoxBahan = view.findViewById(R.id.cb_bahan_bahan);
            radioGroupListBahan = view.findViewById(R.id.rg_listbarang_bahan);
            layoutListHarga = view.findViewById(R.id.linear_pilihbahan_bahan);
            layout = view.findViewById(R.id.linear_root_bahan);
            setActionRadioButton();
        }

        private void setActionRadioButton(){
            checkBoxBahan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkBoxBahan.isChecked()){
                        layout.setVisibility(View.VISIBLE);
                    }
                    else{
                        layout.setVisibility(View.GONE);
                    }
                }
            });
        }

        void bindItem(final BarangTokoList barangTokoList,final int position,final String keyword){
            namaBahan.setText(keyword);
            checkBoxBahan.setChecked(true);
            boolean flag = true;
            for(int i=0;i<barangTokoList.getListBarang().size();i++){
                Barang barang = barangTokoList.getListBarang().get(i);
                String match = barangTokoList.getListBarang().get(i).getNama().toLowerCase();
                if(match.contains(keyword.toLowerCase())){
                    RadioButton radioButton = getRadioButton(barang, position, i);
                    if(flag){
                        radioButton.setChecked(true);
                        flag = false;
                    }
                    addTextViewHarga(barang, position, i);
                }
            }
        }

        private RadioButton getRadioButton(Barang barang, Integer position, int increment){
            RadioButton radioButton = new RadioButton(context);
            radioButton.setId((position+1)*(increment+1));
            radioButton.setText(barang.getNama());
            radioButton.setLayoutParams(
                    new LinearLayout
                            .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            radioGroupListBahan.addView(radioButton);
            return radioButton;
        }

        private void addTextViewHarga(Barang barang, int position, int increment){
            TextView hargaBahan = new TextView(context);
            hargaBahan.setId((position+1)*100+(increment+1));
            Integer harga = barang.getHarga().intValue();
            hargaBahan.setText(harga.toString());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,14,20,14);
            hargaBahan.setLayoutParams(params);
            hargaBahan.setGravity(Gravity.RIGHT);
            layoutListHarga.addView(hargaBahan);
        }

        @Override
        public String getBarangName() {
            rbSelectedId = radioGroupListBahan.getCheckedRadioButtonId();
            RadioButton rb = view.findViewById(rbSelectedId);
            return rb.getText().toString();
        }

        @Override
        public Boolean getStatusCheckboxChecked() {
            return checkBoxBahan.isChecked();
        }
    }
}
