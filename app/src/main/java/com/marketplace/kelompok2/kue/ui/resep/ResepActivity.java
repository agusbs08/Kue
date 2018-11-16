package com.marketplace.kelompok2.kue.ui.resep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.ui.listtoko.PilihTokoActivity;
import com.marketplace.kelompok2.kue.ui.pilihbahan.PilihBahanActivity;
import com.squareup.picasso.Picasso;

public class ResepActivity extends AppCompatActivity implements ResepView {

    private TextView tvNamaResep;
    private TextView tvBahan;
    private TextView tvCaraMemasak;
    private ImageView imgImageResep;
    private Button btnBeli;
    private ImageView btnAddWishlist;
    private ResepPresenter presenter;
    private Integer idResep;
    private String namaResep;
    private String[] caraResep;
    private String[] bahanResep;
    private String imageResep;
    private String[] justBahan;
    private boolean status;
    private Integer idFavorit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_resep);
        initView();
        initComponent();
        initActionView();
        showData();
        setActionIntent();
        presenter.getResepStatus(idResep, getApplicationContext(), 0);
    }

    private void setActionIntent(){
        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PilihTokoActivity.class);
                intent.putExtra("listBahan", justBahan);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        tvNamaResep = findViewById(R.id.tv_nama_produk_resep_beranda);
        tvBahan = findViewById(R.id.tv_isibahan_resep_beranda);
        tvCaraMemasak = findViewById(R.id.tv_isicara_resep_beranda);
        imgImageResep = findViewById(R.id.img_resep);
        btnAddWishlist = findViewById(R.id.btn_addwishlist_resep);
        btnBeli = findViewById(R.id.btn_beli_resep_beranda);
    }

    private void initComponent(){
        presenter = new ResepPresenter(this);
        Intent intent = getIntent();
        idResep = intent.getIntExtra("idResep", 0);
        namaResep = intent.getStringExtra("namaResep");
        caraResep = intent.getStringExtra("caraResep").split("\\.");
        bahanResep = intent.getStringExtra("bahanResep").split("\\.");
        justBahan = new String[bahanResep.length];
        imageResep = intent.getStringExtra("imageResep");
        initData();
    }

    private void initData(){
        for(int i = 0 ; i < justBahan.length; i++){
            String[] temp = bahanResep[i].split(",");
            justBahan[i] = temp[0];
        }
    }

    private void showData(){
        tvNamaResep.setText(namaResep);
        for(int i = 1; i <= bahanResep.length; i++){
            tvBahan.append(i + ". " + bahanResep[i-1] + "\n");
        }
        for(int i = 1; i <= caraResep.length; i++){
            tvCaraMemasak.append(i + ". " + caraResep[i-1] + "\n");
        }
        Picasso.get().load(imageResep).into(imgImageResep);
    }

    private void initActionView(){
        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PilihTokoActivity.class);
                intent.putExtra("listBahan", justBahan);
                startActivity(intent);
            }
        });

        btnAddWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status == false){
                    presenter.addWishlist(idResep, getApplicationContext());
                }
                else{
                    presenter.deleteWishlist(idFavorit, getApplicationContext());
                }
            }
        });
    }

    @Override
    public void showResep(Resep resep) {
        Picasso.get().load(BuildConfig.BASE_URL + resep.getImageResep()).into(imgImageResep);
    }

    @Override
    public void setImageWishlist(boolean status, Integer idFavorit) {
        this.status = status;
        this.idFavorit = idFavorit;
        if(status == false){
            btnAddWishlist.setImageResource(R.drawable.ic_basic_heart);
        }
        else{
            btnAddWishlist.setImageResource(R.drawable.ic_red_heart);
        }
    }
}
