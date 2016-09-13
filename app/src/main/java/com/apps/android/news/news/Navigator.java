package com.apps.android.news.news;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.apps.android.news.news.ui.activity.IntroActivity;
import com.apps.android.news.news.ui.activity.MainActivity;

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

}
