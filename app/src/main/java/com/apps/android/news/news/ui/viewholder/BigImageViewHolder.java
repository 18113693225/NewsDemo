package com.apps.android.news.news.ui.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.entity.Image;
import com.apps.android.news.news.db.greendao.entity.News;

import butterknife.Bind;
import butterknife.ButterKnife;
import support.ui.adapters.EasyViewHolder;

/**
 * Created by android on 2016/9/17.
 */
public class BigImageViewHolder extends EasyViewHolder<News> {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.big_iv)
    ImageView image;
    @Bind(R.id.label_tv)
    TextView label;


    public BigImageViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_big_image);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindTo(int position, News value) {
        title.setText(value.getTitle());
    }
}
