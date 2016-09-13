package com.apps.android.news.news.api.service;

import com.apps.android.news.news.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by android on 2016/9/13.
 */
public interface TabService {
    /**
     * 获取头部选项卡
     */
    @FormUrlEncoded
    @POST("/dsfa/do")
    Call<User> Image(@Field("avatar") String avatar);

    /**
     * 分享
     */
    @GET("/driver/share/info")
    Call<User> ShareInfo(@Query("key") String key);
}
