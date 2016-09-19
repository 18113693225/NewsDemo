package com.apps.android.news.news.api.service;

import com.apps.android.news.news.model.DSFAModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/9/18.
 */
public interface IDSFAService {
    public static final String POST = "doMobilePost";
    public static final String KEY = "dreamsoft";

    /**
     * 获取所有频道
     * @param param
     * @return
     */
    @FormUrlEncoded
    @POST(POST)
    Call<DSFAModel> doPost(@Field(KEY) String param);
}
