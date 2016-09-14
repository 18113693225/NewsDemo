package com.apps.android.news.news.ui.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;
import com.apps.android.news.news.ui.app.NewsApp;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by android on 2016/9/13.
 */
public class IntroActivity extends AppIntro {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("第一页", "welcome first", R.drawable.bg_test, Color.parseColor("#FFA500")));
        addSlide(AppIntroFragment.newInstance("第二页", "welcome two", R.drawable.bg_test, Color.parseColor("#FFA500")));
        addSlide(AppIntroFragment.newInstance("第三页", "welcome three", R.drawable.bg_test, Color.parseColor("#FFA500")));
        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        NewsApp.enterApp();
        Navigator.startMainActivity(IntroActivity.this);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);

    }


}
