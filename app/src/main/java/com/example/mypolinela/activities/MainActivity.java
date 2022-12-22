package com.example.mypolinela.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.example.mypolinela.R;
import com.example.mypolinela.adapter.SliderPagerAdapter;
import com.example.mypolinela.decoration.BannerSlider;
import com.example.mypolinela.decoration.SliderIndicator;
import com.example.mypolinela.fragment.FragmentSlider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private BannerSlider bannerSlider;
    private LinearLayout mLinearLayout;

    private CardView ekbis, pangan, ternak, himabun, tani, pasca, about, polinela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bannerSlider = findViewById(R.id.sliderView);
        mLinearLayout = findViewById(R.id.pagesContainer);
        setupSlider();

        ekbis = (CardView) findViewById(R.id.ekbis);
        ternak = (CardView) findViewById(R.id.ternak);
        pangan = (CardView) findViewById(R.id.pangan);
        himabun = (CardView) findViewById(R.id.kebun);
        tani = (CardView) findViewById(R.id.tektan);
        pasca = (CardView) findViewById(R.id.pasca);
        about = (CardView) findViewById(R.id.about);
        polinela = (CardView) findViewById(R.id.polinela);



        ekbis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EkbisActivity.class);
                startActivity(i);
            }
        });

        ternak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TernakActivity.class);
                startActivity(i);
            }
        });

        pangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PanganActivity.class);
                startActivity(i);
            }
        });

        himabun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),KebunActivity.class);
                startActivity(i);
            }
        });

        tani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TaniActivity.class);
                startActivity(i);
            }
        });

        pasca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PascaActivity.class);
                startActivity(i);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
            }
        });

        polinela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PolinelaActivity.class);
                startActivity(i);
            }
        });


    }

    private void setupSlider() {
        bannerSlider.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        //link image
        fragments.add(FragmentSlider.newInstance("https://polinela.ac.id/wp-content/uploads/2022/12/Header-Pascasarjana-Politeknik-Negeri-Lampung-1200x350-1.jpg"));
        fragments.add(FragmentSlider.newInstance("https://polinela.ac.id/wp-content/uploads/2022/11/Polinela-Program-Studi-D4-S1-Terapan-1200x350p.jpg"));
        fragments.add(FragmentSlider.newInstance("https://polinela.ac.id/wp-content/uploads/2022/11/Polinela-Program-Studi-D3-1200x350p.jpg"));
        fragments.add(FragmentSlider.newInstance("https://polinela.ac.id/wp-content/uploads/2022/07/Polinela-Header-Ujian-Mandiri-D2-Fast-Track-2022-1200x350px.jpg"));
        fragments.add(FragmentSlider.newInstance("https://polinela.ac.id/wp-content/uploads/2022/09/Polinela-BerAKHLAK-1200x350-1.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        bannerSlider.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, bannerSlider, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
