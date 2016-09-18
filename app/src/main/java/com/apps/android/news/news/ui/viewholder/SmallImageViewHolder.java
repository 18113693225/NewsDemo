package com.apps.android.news.news.ui.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.entity.News;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import support.ui.adapters.EasyViewHolder;

/**
 * Created by android on 2016/9/17.
 */
public class SmallImageViewHolder extends EasyViewHolder<News> {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.label_tv)
    TextView label;
    Context context;

    public SmallImageViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_right_image);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindTo(int position, News value) {
        title.setText(value.getTitle());
        if (value.getImageList().size() != 0) {
            Glide.with(context).load(value.getImageList().get(0).getImgUrl()).error(R.mipmap.ic_err_big).into(image);
        }
    }
}
