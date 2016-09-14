package com.apps.android.news.news.ui.activity;


import android.os.Bundle;

import com.apps.android.news.news.R;
import com.apps.android.news.news.api.ApiService;
import com.apps.android.news.news.api.service.TabService;
import com.apps.android.news.news.model.Base;
import com.apps.android.news.news.model.Channels;
import com.apps.android.news.news.utils.util.JsonUtils;
import com.apps.android.news.news.utils.util.ParamUtils;
import com.smartydroid.android.starter.kit.network.callback.MessageCallback;
import com.smartydroid.android.starter.kit.utilities.NetworkUtils;

import retrofit2.Call;

/**
 * Created by android on 2016/9/13.
 */
public class IntroActivity extends BaseActivity {
    private NetworkUtils<Channels> mNetworkUtils;
    private TabService mTabService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mTabService = ApiService.createTabService();
        getAllTable();
    }

    private void getAllTable() {
        Base base = new Base();
        base.userId = "dd";
        Call<Channels> tabCall = mTabService.AllTable(ParamUtils.initParam("news\\actions\\mobile\\actions\\userChannel.xml", JsonUtils.get().toJson(base)));
        mNetworkUtils = NetworkUtils.create(new MessageCallback<Channels>(this) {

            @Override
            public void respondSuccess(Channels data) {
                super.respondSuccess(data);
                String id = data.channels.get(0).id;

            }

        });
        mNetworkUtils.enqueue(tabCall);
    }


}
