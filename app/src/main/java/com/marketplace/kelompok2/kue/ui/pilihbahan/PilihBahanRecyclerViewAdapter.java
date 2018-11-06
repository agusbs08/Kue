package com.marketplace.kelompok2.kue.ui.pilihbahan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
        private RecyclerView recyclerView;
        private LinearLayout layout;
        private int state;

        private PilihBarangRecyclerViewAdapter adapter;

        public PilihBahanViewHolder(View view, Context context){
            super(view);
            this.context = context;
            this.view = view;
            state = -1;
            initView();
        }

        private void initView(){
            namaBahan = view.findViewById(R.id.tv_namabahan_bahan);
            checkBoxBahan = view.findViewById(R.id.cb_bahan_bahan);
            radioGroupListBahan = view.findViewById(R.id.rg_listbarang_bahan);
            recyclerView = view.findViewById(R.id.rv_recycler_pilih_bahan);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            layout = view.findViewById(R.id.linear_pilihbahan);
            setActionRadioButton();
        }

        private void setActionRadioButton(){
            checkBoxBahan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkBoxBahan.isChecked()){
                        layout.setVisibility(View.VISIBLE);
                        state = 1;
                    }
                    else{
                        layout.setVisibility(View.GONE);
                        state = 0;
                    }
                }
            });
        }

        void bindItem(BarangTokoList barangTokoList,int position,String keyword){
            if(namaBahan.getText().equals("")){
                namaBahan.setText(keyword);
            }
            if(adapter == null){
                ArrayList<Barang> listBarang = getListBarang(barangTokoList.getListBarang(), keyword, position);
                adapter = new PilihBarangRecyclerViewAdapter(radioGroupListBahan, listBarang, context);
                recyclerView.setAdapter(adapter);
            }
            if(state == -1){
                state = 1;
            }
            if(state == 1){
                layout.setVisibility(View.VISIBLE);
                checkBoxBahan.setChecked(true);
            }
            else{
                layout.setVisibility(View.GONE);
                checkBoxBahan.setChecked(false);
            }
        }

        private ArrayList<Barang> getListBarang(ArrayList<Barang> listBarang, String keyword, Integer position){
            ArrayList<Barang> tmp = new ArrayList<>();
            for(Barang barang : listBarang){
                if(barang.getNama().toLowerCase().contains(keyword.toLowerCase())){
                    tmp.add(barang);
                }
            }
            return tmp;
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
