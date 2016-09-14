package com.apps.android.news.news.db.DbDao;

import android.content.Context;

import com.apps.android.news.news.api.ApiService;
import com.apps.android.news.news.db.DBCipherManager;
import com.apps.android.news.news.model.User;

import org.json.JSONArray;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/13.
 */
public class ChannelDao {

    private DBCipherManager db;
    private static final String SELECTED = "1";
    private static final String UNSELECTED = "0";

    public ChannelDao(Context context) {
        db = DBCipherManager.getInstance(context);
    }

    /**
     * 获取用户关注频道
     *
     * @return
     */
    public JSONArray getUserChannels() {
        return db.queryDatas("select * from channel where isSelected = '" + SELECTED + "'");
    }

    /**
     * 获取所有频道
     *
     * @return
     */
    public JSONArray getChannels() {
        return db.queryDatas("select * from channel");
    }

    /**
     * 更新用户关注频道
     *
     * @param array
     */
    public void updateUserChannels(JSONArray array) {
        db.deleteData("channel", " isSelected = '" + SELECTED + "'");
        db.insertDatasByTransaction("channel", array);
    }

    /**
     * 更新整个频道数据
     */
    public void updateChannels(JSONArray array) {
        Call<User> user = ApiService.createTabService().Image("");
        try {
            Response<User> users = user.execute();
            User u = users.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
