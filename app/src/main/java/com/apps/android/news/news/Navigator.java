package com.apps.android.news.news;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.apps.android.news.news.ui.activity.CertificationActivity;
import com.apps.android.news.news.ui.activity.DoorActivity;
import com.apps.android.news.news.ui.activity.InfoActivity;
import com.apps.android.news.news.ui.activity.IntroActivity;
import com.apps.android.news.news.ui.activity.MainActivity;
import com.apps.android.news.news.ui.activity.NewsDetailSActivity;
import com.apps.android.news.news.ui.activity.RegisterActivity;
import com.apps.android.news.news.ui.activity.ReleaseInfoActivity;
import com.apps.android.news.news.ui.activity.ReleaseNewsActivity;

/**
 * Created by android on 2016/9/13.
 */
public final class Navigator {


    /**
     * 跳转引导页
     */
    public static void startIntroActivity(Activity activity) {
        Intent intent = new Intent(activity, IntroActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到主页
     */
    public static void startMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到新闻详情页
     */
    public static void startNewsDetailsActivity(Activity activity, String url) {
        Intent intent = new Intent(activity, NewsDetailSActivity.class);
        intent.putExtra("url", url);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到企业认证
     */
    public static void startCertificationActivity(Activity activity) {
        Intent intent = new Intent(activity, CertificationActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到信息维护
     */
    public static void startInfoActivity(Activity activity) {
        Intent intent = new Intent(activity, InfoActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到微门户
     */
    public static void startDoorActivity(Activity activity) {
        Intent intent = new Intent(activity, DoorActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到注册
     */
    public static void startRegisterActivity(Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到发布新闻
     */
    public static void startReleaseNewsActivity(Activity activity) {
        Intent intent = new Intent(activity, ReleaseNewsActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到发布信息
     */
    public static void startReleaseInfoActivity(Activity activity) {
        Intent intent = new Intent(activity, ReleaseInfoActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

}
