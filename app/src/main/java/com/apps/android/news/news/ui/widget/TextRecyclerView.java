package com.apps.android.news.news.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.model.User;
import com.smartydroid.android.starter.kit.app.StarterKitApp;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by android on 2016/9/19.
 */
public class TextRecyclerView extends RecyclerView {

    private static final int spanCount = 4;
    private SimpleAdapter mAdapter;

    public TextRecyclerView(Context context) {
        this(context, null);
    }

    public TextRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    private void initialize() {
        setNestedScrollingEnabled(false);
        int spanSize = StarterKitApp.appResources().getDimensionPixelSize(R.dimen.margin_10);
        setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getContext()).color(Color.TRANSPARENT)
                        .size(spanSize / 2)
                        .build());
        mAdapter = new SimpleAdapter();
        setAdapter(mAdapter);
    }

    public void setData(List<Lable> data) {
        mAdapter.setData(data);
    }

    static class SimpleViewHolder extends ViewHolder {
        public Lable data;
        @Bind(R.id.label_name)
        TextView name;

        private SimpleViewHolder(Context context, ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.item_lable_text, parent, false));
            ButterKnife.bind(this, itemView);
        }

        static SimpleViewHolder create(Context context, ViewGroup parent) {
            return new SimpleViewHolder(context, parent);
        }

        public void bind(Lable data) {
            this.data = data;
            name.setText(data.getName());
        }


    }

    /**
     * RecyclerView适配器
     */
    private class SimpleAdapter extends Adapter<ViewHolder> {
        private ArrayList<Lable> mData;

        public SimpleAdapter() {
            mData = new ArrayList<>();
        }

        public void setData(List<Lable> data) {
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return SimpleViewHolder.create(getContext(), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Lable data = mData.get(position);
            final SimpleViewHolder viewHolder = (SimpleViewHolder) holder;
            if (("").equals(data.getName()) || null == data.getName()) {
                return;
            } else {
                viewHolder.bind(data);
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }


}
