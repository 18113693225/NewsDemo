package com.apps.android.news.news.ui.activity;


import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.apps.android.news.news.Navigator;


import com.apps.android.news.news.ui.app.NewsApp;


public class LauncherActivity extends BaseActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (NewsApp.isFirstEnterApp()) {
                    NewsApp.enterApp();
                    Navigator.startIntroActivity(LauncherActivity.this);//进入引导页
                    finish();
                } else {
                    // Navigator.startMainActivity(LauncherActivity.this);
                    Navigator.startIntroActivity(LauncherActivity.this);//进入引导页
                    finish();
                }
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


}
