package com.apps.android.news.news.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by android on 2016/9/16.
 */
public class TableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private ArrayList mData;

    public TableAdapter() {
        mData = new ArrayList<>();
    }

    public void setData(ArrayList data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
