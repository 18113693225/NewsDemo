package com.apps.android.news.news.ui.activity;


import android.os.Bundle;
import android.util.Log;

import com.apps.android.news.news.R;
import com.apps.android.news.news.api.ApiService;
import com.apps.android.news.news.api.service.TabService;
import com.apps.android.news.news.db.DbDao.ChannelDao;
import com.apps.android.news.news.model.Base;
import com.apps.android.news.news.model.Channels;
import com.apps.android.news.news.model.Table;
import com.apps.android.news.news.utils.util.JsonUtils;
import com.apps.android.news.news.utils.util.ParamUtils;
import com.smartydroid.android.starter.kit.model.ErrorModel;
import com.smartydroid.android.starter.kit.network.callback.MessageCallback;
import com.smartydroid.android.starter.kit.utilities.NetworkUtils;

import org.json.JSONArray;

import retrofit2.Call;

/**
 * Created by android on 2016/9/13.
 */
public class IntroActivity extends BaseActivity {
    private NetworkUtils<Channels> mNetworkUtils;
    private TabService mTabService;
    private ChannelDao cDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mTabService = ApiService.createTabService();
        cDao = new ChannelDao(this);
        getAllTable();
    }

    private void getAllTable() {
        Call<Channels> tabCall = mTabService.AllTable(ParamUtils.initParam("news\\actions\\mobile\\actions\\channels.xml", null));
        mNetworkUtils = NetworkUtils.create(new MessageCallback<Channels>(this) {

            @Override
            public void respondSuccess(Channels data) {
                super.respondSuccess(data);
                if (data.channels != null) {
                    cDao.initChannels(data.channels);
                }

            }

        });
        mNetworkUtils.enqueue(tabCall);
    }


}
