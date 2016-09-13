package com.apps.android.news.news.api;

import com.apps.android.news.news.api.service.TabService;
import com.smartydroid.android.starter.kit.retrofit.RetrofitBuilder;

import retrofit2.Retrofit;

/**
 * Created by android on 2016/9/13.
 */
public class ApiService {

    private static Retrofit retrofit() {
        return RetrofitBuilder.get().retrofit();
    }

    /**
     * 选项卡接口
     */
    public static TabService createTabService() {
        return retrofit().create(TabService.class);
    }


}
