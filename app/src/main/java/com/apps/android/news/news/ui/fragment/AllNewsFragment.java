package com.apps.android.news.news.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.android.news.news.R;
import com.apps.android.news.news.ui.adapter.CustomRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;


/**
 * Created by android on 2016/9/13.
 */
public class AllNewsFragment extends Fragment {
    private Context mContext;
    public Bundle args;
    private BGARefreshLayout mBGARefreshLayout;
    private RecyclerView mRecyclerView;


    /**
     * 数据
     */
    private List<String> mListData = new ArrayList<String>();
    /**
     * 一次加载数据的条数
     */
    private int DATASIZE = 10;
    /**
     * 数据填充adapter
     */
    private CustomRecyclerViewAdapter mRecyclerViewAdapter = null;
    /**
     * 设置一共请求多少次数据
     */
    private int ALLSUM = 0;

    /**
     * 设置刷新和加载
     */
    // private DefineBAGRefreshWithLoadView mDefineBAGRefreshWithLoadView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
//        ButterKnife.bind(this, view);
        return view;
    }


}
