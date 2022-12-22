package com.example.mypolinela.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypolinela.R;

public class ProdiEkbis extends AppCompatActivity {

    private SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodi_ekbis);



        //        load database
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

//        ambil kode prodi yang dipilih dari menu sebelumnya, menu daftar prodi
        String kd_prodi = getIntent().getStringExtra("kd_prodi");

//        ambil data prodi dari database
        String query_ekbis = "SELECT nm_prodi,tentang,visi,misi,tujuan  FROM ekbis WHERE kd_prodi = '" + kd_prodi + "'";
        Cursor cursor_ekbis = db.rawQuery(query_ekbis, null);
        cursor_ekbis.moveToFirst();



//        tampilkan data prodi kedalam textview
        TextView tv_nm_prodi = findViewById(R.id.tv_nm_prodi);
        TextView tv_nm_tentang = findViewById(R.id.tv_nm_tentang);
        TextView tv_nm_visi = findViewById(R.id.tv_nm_visi);
        TextView tv_nm_misi = findViewById(R.id.tv_nm_misi);
        TextView tv_nm_tujuan = findViewById(R.id.tv_nm_tujuan);


        tv_nm_prodi.setText(cursor_ekbis.getString(0));
        tv_nm_tentang.setText(cursor_ekbis.getString(1));
        tv_nm_visi.setText(cursor_ekbis.getString(2));
        tv_nm_misi.setText(cursor_ekbis.getString(3));
        tv_nm_tujuan.setText(cursor_ekbis.getString(4));


        cursor_ekbis.close();



    }

    //    biar tombol back di toolbar dan tombol back di device tidak me restart menu sebelumnya/menu activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}