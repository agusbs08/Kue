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
        }

        void bindItem(final BarangTokoList barangTokoList,final int position,final String keyword){
            namaBahan.setText(keyword);
            checkBoxBahan.setChecked(true);
            boolean flag = true;
            LinearLayout linearLayout = view.findViewById(R.id.linear_pilihbahan_bahan);
            for(int i=0;i<barangTokoList.getListBarang().size();i++){
                Barang barang = barangTokoList.getListBarang().get(i);
                String match = barangTokoList.getListBarang().get(i).getNama().toLowerCase();
                if(match.contains(keyword.toLowerCase())){
                    RadioButton radioButton = new RadioButton(context);
                    radioButton.setId((position+1)*(i+1));
                    radioButton.setText(barang.getNama());
                    radioButton.setLayoutParams(
                            new LinearLayout
                                    .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    );
                    if(flag){
                        radioButton.setChecked(true);
                        flag = false;
                    }
                    radioGroupListBahan.addView(radioButton);
                    TextView hargaBahan = new TextView(context);
                    hargaBahan.setId((position+1)*100+(i+1));
                    Integer harga = barang.getHarga().intValue();
                    hargaBahan.setText(harga.toString());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0,14,20,14);
                    hargaBahan.setLayoutParams(params);
                    hargaBahan.setGravity(Gravity.RIGHT);
                    linearLayout.addView(hargaBahan);
                }
            }
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
