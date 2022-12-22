package com.example.mypolinela.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mypolinela.R;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(EkbisActivity ekbisActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = ekbisActivity;
        this.list_data = list_data;
    }

    public AdapterList(KebunActivity kebunActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = kebunActivity;
        this.list_data = list_data;
    }

    public AdapterList(PanganActivity panganActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = panganActivity;
        this.list_data = list_data;
    }

    public AdapterList(TaniActivity taniActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = taniActivity;
        this.list_data = list_data;
    }

    public AdapterList(TernakActivity ternakActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = ternakActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_prodi, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txthape.setText(list_data.get(position).get("nm_prodi"));

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox txthape;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}