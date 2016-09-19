package com.apps.android.news.news.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.dao.NewsManager;
import com.apps.android.news.news.db.greendao.entity.News;
import com.apps.android.news.news.ui.adapter.CustomRecyclerViewAdapter;
import com.apps.android.news.news.ui.widget.DefineBAGRefreshWithLoadView;
import com.apps.android.news.news.ui.widget.EmptyRecyclerView;
import com.smartydroid.android.starter.kit.utilities.DividerItemDecoration;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;


/**
 * Created by android on 2016/9/13.
 */
public class AllNewsFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private Context mContext;
    public Bundle args;
    public String id;
    @Bind(R.id.bga_rl)
    BGARefreshLayout mBGARefreshLayout;
    @Bind(R.id.news_rv)
    RecyclerView mRecyclerView;
    private List<News> AllNewsList = new ArrayList<News>();
    private List<News> newsList;
    private CustomRecyclerViewAdapter mRecyclerViewAdapter = null;
    private DefineBAGRefreshWithLoadView mDefineBAGRefreshWithLoadView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
        id = args.getString("ID");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBGARefreshLayout.beginRefreshing();
        onBGARefreshLayoutBeginRefreshing(mBGARefreshLayout);
    }


    private void init() {
        mContext = getActivity();
        mBGARefreshLayout.setDelegate(this);
        setBgaRefreshLayout();
        setRecyclerView();
        setRecyclerCommAdapt();
    }

    private void getNews(String id, String time) {
        newsList = NewsManager.getInstance(getActivity()).getNewsByLable(id, time);
    }

    private void setBgaRefreshLayout() {
        mDefineBAGRefreshWithLoadView = new DefineBAGRefreshWithLoadView(mContext, true, true);
        mBGARefreshLayout.setRefreshViewHolder(mDefineBAGRefreshWithLoadView);
        mDefineBAGRefreshWithLoadView.updateLoadingMoreText("加载更多");
    }


    private void setRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()
        ).size(1).color(Color.TRANSPARENT).build());
    }


    private void setRecyclerCommAdapt() {
        mRecyclerViewAdapter = new CustomRecyclerViewAdapter(mContext, AllNewsList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.setOnItemClickListener(new CustomRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Navigator.startNewsDetailsActivity(getActivity(), AllNewsList.get(position).getUrl());
            }
        });

    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        handler.sendEmptyMessageDelayed(0, 2000);
    }


    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        try {
            if (newsList.size() != 0) {
                String time = newsList.get(newsList.size() - 1).getAuditDate();
                getNews(id, time);
                if (newsList.size() == 0) {
                    handler.sendEmptyMessageDelayed(2, 1000);
                    return true;
                } else {
                    handler.sendEmptyMessageDelayed(1, 500);
                }
            } else {
                handler.sendEmptyMessageDelayed(2, 500);
            }

        } catch (Exception e) {
            Log.i("TAG", "null");
        }
        return true;
    }

    /**
     * 模拟请求网络数据
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    AllNewsList.clear();
                    getNews(id, null);
                    AllNewsList.addAll(newsList);
                    mBGARefreshLayout.endRefreshing();
                    break;
                case 1:
                    AllNewsList.addAll(newsList);
                    mBGARefreshLayout.endLoadingMore();
                    break;
                case 2:
                    mDefineBAGRefreshWithLoadView.updateLoadingMoreText("没有更多数据");
                    mDefineBAGRefreshWithLoadView.hideLoadingMoreImg();
                    mBGARefreshLayout.endLoadingMore();
                    break;
                default:
                    break;

            }
        }
    };
}
