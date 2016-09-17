package com.apps.android.news.news.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apps.android.news.news.R;
import com.apps.android.news.news.ui.adapter.CustomRecyclerViewAdapter;
import com.apps.android.news.news.ui.widget.DefineBAGRefreshWithLoadView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;


/**
 * Created by android on 2016/9/13.
 */
public class AllNewsFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private Context mContext;
    public Bundle args;

    @Bind(R.id.bga_rl)
    public BGARefreshLayout mBGARefreshLayout;
    @Bind(R.id.news_rv)
    public RecyclerView mRecyclerView;
    // 数据
    private List<String> mListData = new ArrayList<String>();
    //一次加载数据的条数
    private int DATASIZE = 10;
    // 数据填充adapter
    private CustomRecyclerViewAdapter mRecyclerViewAdapter = null;
    // 设置一共请求多少次数据
    private int ALLSUM = 0;
    // 设置刷新和加载
    private DefineBAGRefreshWithLoadView mDefineBAGRefreshWithLoadView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        initView();
        return view;
    }

    /**
     * 进入页面首次加载数据
     */
    @Override
    public void onStart() {
        super.onStart();
        mBGARefreshLayout.beginRefreshing();
        onBGARefreshLayoutBeginRefreshing(mBGARefreshLayout);
    }


    private void initView() {
        //设置刷新和加载监听
        mBGARefreshLayout.setDelegate(this);
        setBgaRefreshLayout();
        setRecyclerView();
    }

    /**
     * 设置 BGARefreshLayout刷新和加载
     */
    private void setBgaRefreshLayout() {
        mDefineBAGRefreshWithLoadView = new DefineBAGRefreshWithLoadView(mContext, true, true);
        //设置刷新样式
        mBGARefreshLayout.setRefreshViewHolder(mDefineBAGRefreshWithLoadView);
        mDefineBAGRefreshWithLoadView.updateLoadingMoreText("自定义加载更多");
    }

    /**
     * 设置RecyclerView的布局方式
     */
    private void setRecyclerView() {
        //垂直listview显示方式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
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
                    mListData.clear();
                    setData();
                    mBGARefreshLayout.endRefreshing();
                    break;
                case 1:
                    setData();
                    mBGARefreshLayout.endLoadingMore();
                    break;
                case 2:
                    mBGARefreshLayout.endLoadingMore();
                    break;
                default:
                    break;

            }
        }
    };

    /**
     * 添加假数据
     */
    private void setData() {
        for (int i = 0; i < DATASIZE; i++) {
            mListData.add("第" + (ALLSUM * 10 + i) + "条数据");
        }
        if (ALLSUM == 0) {
            setRecyclerCommadapter();
        } else {
            mRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 数据填充
     */
    private void setRecyclerCommadapter() {
        mRecyclerViewAdapter = new CustomRecyclerViewAdapter(mContext, mListData);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        //点击事件
        mRecyclerViewAdapter.setOnItemClickListener(new CustomRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(mContext, "onclick  " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 刷新
     */
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mDefineBAGRefreshWithLoadView.updateLoadingMoreText("自定义加载更多");
        mDefineBAGRefreshWithLoadView.showLoadingMoreImg();
        ALLSUM = 0;
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    /**
     * 加载
     */
    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        if (ALLSUM == 2) {
            /** 设置文字 **/
            mDefineBAGRefreshWithLoadView.updateLoadingMoreText("没有更多数据");
            /** 隐藏图片 **/
            mDefineBAGRefreshWithLoadView.hideLoadingMoreImg();
            handler.sendEmptyMessageDelayed(2, 2000);
            return true;
        }
        ALLSUM++;
        handler.sendEmptyMessageDelayed(1, 2000);
        return true;
    }

}
