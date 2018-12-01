package com.marketplace.kelompok2.kue.ui.pilihbahan;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.BerhasilActivity;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Barang;
import com.marketplace.kelompok2.kue.model.BarangTokoList;
import com.marketplace.kelompok2.kue.model.list.BarangList;
import com.marketplace.kelompok2.kue.model.response.DataResponse;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.marketplace.kelompok2.kue.ui.listtoko.PilihTokoActivity;
import com.marketplace.kelompok2.kue.ui.nota.NotaActivity;

import java.util.ArrayList;

public class PilihBahanActivity extends AppCompatActivity implements PilihBahanView {


    private ProgressBar pb;
    private String[] listBahan;
    private RecyclerView recyclerView;
    private PilihBahanRecyclerViewAdapter adapter;
    private PilihBahanPresenter presenter;
    private ArrayList<BarangTokoList> listBarang;

    private Button btnTes;
    private ArrayList<PilihBahanRecyclerViewAdapter.PilihBahanViewHolder> listViewHolder;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bahan);
        initData();
        initView();
        hideLoading();
        actionBtnOnclick();
    }

    private void initData(){
        listBarang = new ArrayList<>();
        Intent intent = getIntent();
        listBahan = intent.getStringArrayExtra("listBahan");
        BarangTokoList barangTokoList = (BarangTokoList) intent.getSerializableExtra("barangTokoList");
        UserState.getInstance().setPenjual(barangTokoList.getPenjual());
        listBarang.add(barangTokoList);
    }

    private void initView(){
        listViewHolder = new ArrayList<>();
        pb = findViewById(R.id.pb_pilih_bahan);
        recyclerView = findViewById(R.id.rv_listbarang_pilih_bahan);
        adapter = new PilihBahanRecyclerViewAdapter(listBarang, getApplicationContext(), listViewHolder);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        presenter = new PilihBahanPresenter(this);
        btnTes = findViewById(R.id.btn_tes_bahan);
        spinner = findViewById(R.id.spinner_metodebayar_bahan);
        spinner.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.spinner_item, R.layout.support_simple_spinner_dropdown_item ));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner.setSelection(0);
    }

    private void actionBtnOnclick(){
        btnTes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Barang> listBarangs = getListBahan();
                Float total = getTotalHarga(listBarangs);
                Toast.makeText(getApplicationContext(), total.toString(), Toast.LENGTH_SHORT).show();
                presenter.addToCart(listBarangs, total);
            }
        });
    }

    private Float getTotalHarga(ArrayList<Barang> listBarang){
        Float total = new Float(0);
        for(Barang barang : listBarang){
            total += barang.getHarga();
        }
        return total;
    }

    private ArrayList<Barang> getListBahan(){
        ArrayList<Barang> listBarang = new ArrayList<>();
        for(int i=0;i<listViewHolder.size();i++){
            if(listViewHolder.get(i).getStatusCheckboxChecked()){
               String keyword = listViewHolder.get(i).getBarangName();
               listBarang.add(getBarangFromKeyword(keyword));
            }
        }
        return listBarang;
    }

    private Barang getBarangFromKeyword(String keyword){
        ArrayList<Barang> dumpBarang = listBarang.get(0).getListBarang();
        Barang barang = null;
        for(int i=0;i<dumpBarang.size();i++){
            Barang tmp = dumpBarang.get(i);
            if(tmp.getNama().equals(keyword)){
                barang = tmp;
                break;
            }
        }
        return barang;
    }

    @Override
    public void showListBahan(ArrayList<BarangTokoList> listBarang) {
        this.listBarang.clear();
        this.listBarang.addAll(listBarang);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void actionAddToCartSuccess() {
        Toast.makeText(getApplicationContext(), "Add to cart success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void actionAddToCartFailed() {
        Toast.makeText(getApplicationContext(), "Add to cart failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }
}