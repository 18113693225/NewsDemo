package com.apps.android.news.news.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.android.news.news.R;

import java.util.List;

/**
 * Created by android on 2016/9/17.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    protected List<String> mListData;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public CustomRecyclerViewAdapter(Context context, List<String> datas) {
        this.mListData = datas;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    //创建ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_text, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    //绑定ViewHolder
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        TextView text = (TextView) holder.itemView.findViewById(R.id.text);
        text.setText(mListData.get(position));
        setOnListener(holder);
    }

    //触发
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


    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
