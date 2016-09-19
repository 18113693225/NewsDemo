package com.apps.android.news.news.api;

import com.apps.android.news.news.api.service.IDSFAService;
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
     * 产业头条服务
     * @return
     */
    public static IDSFAService createDSFAService(){
        return retrofit().create(IDSFAService.class);
    }


}
