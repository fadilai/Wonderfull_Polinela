package com.example.mypolinela.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mypolinela.R;
import com.example.mypolinela.adapter.SliderPagerAdapter;
import com.example.mypolinela.decoration.BannerSlider;
import com.example.mypolinela.decoration.SliderIndicator;
import com.example.mypolinela.fragment.FragmentSlider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EkbisActivity extends AppCompatActivity {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private BannerSlider bannerSlider;
    private LinearLayout mLinearLayout;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekbis);
        bannerSlider = findViewById(R.id.sliderView);
        mLinearLayout = findViewById(R.id.pagesContainer);
        setupSlider();


        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

        ListView lv_daftar_prodi = findViewById(R.id.list);

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
//        ambil data prodi dari database
        String query_prodi = "SELECT kd_prodi,nm_prodi FROM ekbis ORDER BY kd_prodi";
        Cursor cursor_prodi = db.rawQuery(query_prodi, null);
        while (cursor_prodi.moveToNext()) {
//            masukkan ke list
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("kd_prodi", cursor_prodi.getString(0));
            map.put("nm_prodi", cursor_prodi.getString(1));
            list.add(map);
        }
        cursor_prodi.close();


//        adapter untuk listview
        SimpleAdapter adapter = new SimpleAdapter(
                EkbisActivity.this,
                list,
                R.layout.list_prodi,
                new String[]{"kd_prodi", "nm_prodi"},
                new int[]{R.id.kd_prodi, R.id.nm_prodi});
        lv_daftar_prodi.setAdapter(adapter);

//        jika di klik salah satu prodi tampilkan activity detail prodi
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                LinearLayout linearLayout = (LinearLayout) container;
                TextView tv_kd_prodi = (TextView) linearLayout.getChildAt(0);
//                TextView tv_kode_penyakit = (TextView) findViewById(R.id.kode_penyakit);
                Intent intent = new Intent(EkbisActivity.this, ProdiEkbis.class);
                intent.putExtra("kd_prodi", tv_kd_prodi.getText().toString());
                startActivity(intent);
            }
        };

        lv_daftar_prodi.setOnItemClickListener(itemClickListener);


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

    private void setupSlider() {
        bannerSlider.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        //link image
        fragments.add(FragmentSlider.newInstance("https://polinela.ac.id/wp-content/uploads/2019/02/images_jurusan_ekonomi_dan_bisnis.jpg"));


        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        bannerSlider.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, bannerSlider, R.drawable.kosng);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}