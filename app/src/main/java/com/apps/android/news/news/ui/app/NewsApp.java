package com.apps.android.news.news.ui.app;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.apps.android.news.news.BuildConfig;
import com.apps.android.news.news.db.DBManager;
import com.apps.android.news.news.db.greendao.dao.LableManager;
import com.apps.android.news.news.db.greendao.dao.NewsManager;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.db.greendao.gen.LableDao;
import com.apps.android.news.news.model.User;
import com.apps.android.news.news.utils.util.JsonUtils;
import com.smartydroid.android.starter.kit.StarterKit;
import com.smartydroid.android.starter.kit.account.Account;
import com.smartydroid.android.starter.kit.app.StarterKitApp;
import com.smartydroid.android.starter.kit.retrofit.RetrofitBuilder;

import java.util.Iterator;
import java.util.List;

/**
 * Created by android on 2016/9/13.
 */
public class NewsApp extends StarterKitApp {


    private static Context sContext;

    public static Context getsContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new StarterKit.Builder().setDebug(BuildConfig.DEBUG).build();
        new RetrofitBuilder.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .build();
        DBManager.getInstance(appContext());
        initTestData();
    }

    private void initTestData() {//初始化测试数据
        LableManager.getInstance(appContext()).initTestData();
        NewsManager.getInstance(appContext()).initTestData();
    }

    @Override
    public Account accountFromJson(String json) {
        return JsonUtils.get().toObject(json, User.class);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
