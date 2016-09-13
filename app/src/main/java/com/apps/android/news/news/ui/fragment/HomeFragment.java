package com.apps.android.news.news.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.ui.adapter.NewsFragmentPagerAdapter;
import com.apps.android.news.news.ui.widget.MenuHorizontalScrollView;
import com.apps.android.news.news.utils.tool.WindowsTool;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.home_top_content)
    LinearLayout home_top_content;

    @Bind(R.id.home_top_hsv)
    MenuHorizontalScrollView horizontalScrollView;

    @Bind(R.id.mViewPager)
    ViewPager mViewPager;


    ArrayList<Fragment> channelFragments;
    int mScreenWidth;//屏幕宽度

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {

    }


    public void selectTab(int position) {
        int count = home_top_content.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = home_top_content.getChildAt(i);
            if (view.isSelected()) view.setSelected(false);
            if (i == position) {
                view.setSelected(true);
                int k = view.getMeasuredWidth();
                int l = view.getLeft();
                int i2 = l + k / 2 - mScreenWidth / 2;
                horizontalScrollView.smoothScrollTo(i2, 0);
            }
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
