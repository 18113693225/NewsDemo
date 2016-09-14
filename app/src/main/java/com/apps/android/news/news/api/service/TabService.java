package com.apps.android.news.news.api.service;

import com.apps.android.news.news.model.Channels;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;


/**
 * Created by android on 2016/9/13.
 */
public interface TabService {

    /**
     * 获取所有选项卡
     */
    @FormUrlEncoded
    @POST("/dsfa/doMobilePost")
    Call<Channels> AllTable(@Field("dreamsoft") String param);

    /**
     * 获取头部选项卡
     */
    @FormUrlEncoded
    @POST("/dsfa/doMobilePost")
    Call<Channels> MyTable(@Field("dreamsoft") String param);


}
