package com.marketplace.kelompok2.kue.ui.editprofil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.common.UserState;
import com.marketplace.kelompok2.kue.model.Pembeli;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class EditProfilActivity extends AppCompatActivity implements EditProfilView {

    private ImageButton imgUser;
    private EditText namaUser;
    private EditText emailUser;
    private EditText nomerUser;
    private EditText alamatUser;
    private Button btnSimpan;

    private EditProfilPresenter presenter;
    private Bitmap foto;

    private int bitmap_size = 40; // image quality 1 - 100;
    private int max_resolution_image = 800;

    private String TAG = EditProfilActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_editprofile);
        initView();
        initData();
    }

    private void initData(){
        if(UserState.getInstance().getPembeli().getNama() == null){
            namaUser.setText(UserState.getInstance().getPembeli().getUsername());
        }
        else{
            namaUser.setText(UserState.getInstance().getPembeli().getNama());
        }
        emailUser.setText(UserState.getInstance().getPembeli().getEmail());
        nomerUser.setText(UserState.getInstance().getPembeli().getNoTlp());
        if(UserState.getInstance().getPembeli().getGambarPembeli() != null){
            loadImage();
        }
    }

    private void loadImage(){
        Picasso.get().load(UserState.getInstance().getPembeli().getGambarPembeli()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                foto = bitmap;
                imgUser.setImageBitmap(foto);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    private void initView(){
        imgUser = findViewById(R.id.ib_photo_editprofile);
        namaUser = findViewById(R.id.et_namapemilik_editprofile);
        emailUser = findViewById(R.id.et_email_editprofile);
        nomerUser =findViewById(R.id.et_nomor_editprofile);
        alamatUser = findViewById(R.id.et_alamat_editprofile);
        btnSimpan = findViewById(R.id.btn_simpan_editprofile);
        presenter = new EditProfilPresenter(this);
        initBtn();
    }

    private void initBtn(){
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = namaUser.getText().toString();
                String email = emailUser.getText().toString();
                String noTlp = nomerUser.getText().toString();
                Toast.makeText(getApplicationContext(), UserState.getInstance().getPembeli().getId().toString() + username + email + noTlp, Toast.LENGTH_SHORT).show();
                presenter.updateUser(username,email,noTlp,getImage());
            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
    }

    private File getImage(){
        try{
            File f = new File(getApplicationContext().getCacheDir(), "imagepem");
            f.createNewFile();

            Bitmap bitmap = foto;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();
            //write the bytes in file
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            //return bitmapdata;
            return f;
        }
        catch (Exception e){
            Log.e("createFile",e.getMessage());
            return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                setToImageView(getResizedBitmap(bitmap, max_resolution_image));
                foto = bitmap;
            }
            catch (Exception e){
                Log.d(TAG, e.getMessage());
            }
        }
    }

    private void setToImageView(Bitmap bmp) {
        //compress image
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, bytes);
        Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));

        //menampilkan gambar yang dipilih dari camera/gallery ke ImageView
        imgUser.setImageBitmap(decoded);
    }

    private Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    @Override
    public void actionSuccessUpdate() {
        Toast.makeText(getApplicationContext(), "Update Profile Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("state", 3);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
