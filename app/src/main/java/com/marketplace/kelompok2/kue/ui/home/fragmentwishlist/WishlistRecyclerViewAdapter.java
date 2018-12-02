package com.marketplace.kelompok2.kue.ui.home.fragmentwishlist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.BuildConfig;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.model.Resep;
import com.marketplace.kelompok2.kue.model.ResepFavorit;
import com.marketplace.kelompok2.kue.model.list.ResepList;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.marketplace.kelompok2.kue.ui.resep.ResepActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WishlistRecyclerViewAdapter extends RecyclerView.Adapter<WishlistRecyclerViewAdapter.WishlistViewHolder> {

    private ArrayList<ResepFavorit> resepList;
    private Context context;

    public WishlistRecyclerViewAdapter(ArrayList<ResepFavorit> resepList, Context context){
        this.resepList = resepList;
        this.context = context;
    }

    @NonNull
    @Override
    public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WishlistViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.list_card_wishlist, parent, false),
                context);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
        holder.bindItem(resepList.get(position));
    }

    @Override
    public int getItemCount() {
        return resepList.size();
    }

    class WishlistViewHolder extends RecyclerView.ViewHolder implements WishlistRecyclerViewView{
        private ImageView imageResep;
        private TextView namaResep;
        private View view;
        private Context context;
        private ImageButton btnHapus;
        private WishlistRecyclerViewPresenter presenter;

        public WishlistViewHolder(View view, Context context){
            super(view);
            this.view = view;
            this.context = context;
            initView();
        }

        private void initView(){
            imageResep = view.findViewById(R.id.img_item_wishlist);
            namaResep = view.findViewById(R.id.tv_resep_wishlist);
            btnHapus = view.findViewById(R.id.btn_remove_wishlist);
            presenter = new WishlistRecyclerViewPresenter(this);
        }

        void bindItem(ResepFavorit resepFavorit){
            Resep resep = resepFavorit.getResep();
            Picasso.get().load(BuildConfig.BASE_STORAGE + resep.getImageResep()).into(imageResep);
            namaResep.setText(resep.getNamaResep());
            initBtnHapus(resep.getNamaResep(), resepFavorit.getIdFavorit());
            setOnclickItemView(resep);
        }

        private void setOnclickItemView(Resep resep){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ResepActivity.class);
                    intent.putExtra("idResep", resep.getId());
                    intent.putExtra("namaResep", resep.getNamaResep());
                    intent.putExtra("caraResep", resep.getListCara());
                    intent.putExtra("bahanResep", resep.getListBahan());
                    intent.putExtra("imageResep", BuildConfig.BASE_STORAGE + resep.getImageResep());
                    context.startActivity(intent);
                }
            });
        }

        private void initBtnHapus(String namaResep, Integer idFavorit){
            btnHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Apa kamu yakin menghapus " + namaResep + "?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            presenter.deleteWishlist(idFavorit);
                        }
                    });
                    builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            });
        }

        @Override
        public void showActionDeleteSuccess() {
            Toast.makeText(context, "Delete Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtra("state", 1);
            context.startActivity(intent);
        }
    }
}
