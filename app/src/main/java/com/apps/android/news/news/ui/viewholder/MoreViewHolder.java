package com.apps.android.news.news.ui.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.entity.News;

import butterknife.Bind;
import butterknife.ButterKnife;
import support.ui.adapters.EasyViewHolder;

/**
 * Created by android on 2016/9/17.
 */
public class MoreViewHolder extends EasyViewHolder<News> {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.image1)
    ImageView image1;
    @Bind(R.id.image2)
    ImageView image2;
    @Bind(R.id.image3)
    ImageView image3;

    @Bind(R.id.label_tv)

    TextView label;

    public MoreViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_three_image);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindTo(int position, News value) {
        title.setText(value.getTitle());
    }
}
