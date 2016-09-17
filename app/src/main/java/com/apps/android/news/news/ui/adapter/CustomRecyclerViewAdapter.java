package com.apps.android.news.news.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.entity.News;
import com.apps.android.news.news.ui.viewholder.BigImageViewHolder;
import com.apps.android.news.news.ui.viewholder.MoreViewHolder;
import com.apps.android.news.news.ui.viewholder.SmallImageViewHolder;
import com.apps.android.news.news.ui.viewholder.TextViewHolder;

import java.util.List;

import support.ui.adapters.EasyViewHolder;

/**
 * Created by android on 2016/9/17.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<EasyViewHolder> {

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_SMALL = 2;
    public static final int TYPE_MORE = 3;


    protected List<News> mListData;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public CustomRecyclerViewAdapter(Context context, List<News> data) {
        this.mListData = data;
        this.mContext = context;
    }

    //创建ViewHolder
    @Override
    public EasyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        EasyViewHolder holder = null;
        switch (viewType) {
            case TYPE_TEXT:
                holder = new TextViewHolder(mContext, parent);
                break;
            case TYPE_BIG:
                holder = new BigImageViewHolder(mContext, parent);
                break;
            case TYPE_SMALL:
                holder = new SmallImageViewHolder(mContext, parent);
                break;
            case TYPE_MORE:
                holder = new MoreViewHolder(mContext, parent);
                break;
            default:
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(EasyViewHolder holder, int position) {
        News news = mListData.get(position);
        holder.bindTo(position, news);
        setOnListener(holder);
    }


    protected void setOnListener(final RecyclerView.ViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mListData.get(position).getDisplayMode().equals("0")) {
            return TYPE_TEXT;
        } else if (mListData.get(position).getDisplayMode().equals("1")) {
            return TYPE_BIG;
        } else if (mListData.get(position).getDisplayMode().equals("2")) {
            return TYPE_SMALL;
        } else if (mListData.get(position).getDisplayMode().equals("3")) {
            return TYPE_MORE;
        } else {
            return TYPE_TEXT;
        }

    }

}
