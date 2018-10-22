package com.marketplace.kelompok2.kue.ui.pilihbahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.listtoko.PilihTokoActivity;

import java.util.ArrayList;

public class PilihBahanActivity extends AppCompatActivity {

    private LinearLayout layout;
    private String[] listBahan;
    private ArrayList<CheckBox> listCheckBox;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bahan);
        init();
        initView();
        btn = findViewById(R.id.btn_tes);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> tesString = getListString();
                if(tesString.size() == 0){
                    Toast.makeText(getApplicationContext(), "Anda Belum Memilih Bahan", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), PilihTokoActivity.class);
                    intent.putExtra("listBahan", setArrayListStringtoArrayString(tesString));
                    startActivity(intent);
                }
            }
        });
    }

    private ArrayList<String> getListString(){
        ArrayList<String> dump = new ArrayList<>();
        for(int i=0;i<listCheckBox.size();i++){
            if(listCheckBox.get(i).isChecked()){
                dump.add(listBahan[i]);
            }
        }
        return dump;
    }

    private String[] setArrayListStringtoArrayString(ArrayList<String> listString){
        String[] tmp = new String[listString.size()];
        for(int i=0;i<listString.size();i++){
            tmp[i] = listString.get(i);
        }
        return tmp;
    }

    private void init(){
        Intent intent = getIntent();
        listBahan = intent.getStringArrayExtra("listBahan");
        layout = findViewById(R.id.linear_pilih_bahan);
        listCheckBox = new ArrayList<>();
    }

    private void initView(){
        for(int i=0;i<listBahan.length;i++){
            TableRow row =new TableRow(this);
            row.setId(i);
            row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(listBahan[i]);
            row.addView(checkBox);
            listCheckBox.add(checkBox);
            layout.addView(row);
        }
    }
}