package com.apps.android.news.news.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;
import com.apps.android.news.news.api.ApiService;
import com.apps.android.news.news.api.service.TabService;
import com.apps.android.news.news.db.greendao.dao.LableManager;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.model.Channels;
import com.apps.android.news.news.utils.util.ParamUtils;
import com.smartydroid.android.starter.kit.network.callback.MessageCallback;
import com.smartydroid.android.starter.kit.utilities.NetworkUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import info.hoang8f.widget.FButton;
import retrofit2.Call;

/**
 * Created by android on 2016/9/13.
 */
public class IntroActivity extends BaseActivity {
    private NetworkUtils<Channels> mNetworkUtils;
    private TabService mTabService;
    @Bind(R.id.all_table_rc)
    public RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
        getAllTable();
        initView();
    }

    private void getAllTable() {
        Call<Channels> tabCall = mTabService.AllTable(ParamUtils.initParam("news\\actions\\mobile\\actions\\channels.xml", null));
        mNetworkUtils = NetworkUtils.create(new MessageCallback<Channels>(this) {

            @Override
            public void respondSuccess(Channels data) {
                super.respondSuccess(data);
                if (data.channels != null) {
                    //cDao.initChannels(data.channels);
                }

            }

        });
        mNetworkUtils.enqueue(tabCall);
    }

    private void init() {
        mTabService = ApiService.createTabService();
    }

    private void initView() {
        List<Lable> data = LableManager.getInstance(this).getLables();
    }


    @OnClick({R.id.register_bt, R.id.look_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_bt:
                break;
            case R.id.look_bt:
                Navigator.startMainActivity(IntroActivity.this);
                finish();
                break;
            default:
                break;
        }
    }


}
