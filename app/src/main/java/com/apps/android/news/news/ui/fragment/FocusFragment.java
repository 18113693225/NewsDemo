package com.apps.android.news.news.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.android.news.news.R;
import com.apps.android.news.news.ui.adapter.BusinessFragmentAdapter;
import com.apps.android.news.news.ui.adapter.FocusFragmentAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FocusFragment extends Fragment {
    @Bind(R.id.frg_focus_tab)
    TabLayout mTabLayout;
    @Bind(R.id.frg_focus_viewpager)
    ViewPager mViewpager;
    FocusFragmentAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus, container, false);
        ButterKnife.bind(this, view);
        setUpTabLayout();
        return view;

    }

    private void setUpTabLayout() {
        mAdapter = new FocusFragmentAdapter(getChildFragmentManager());
        mViewpager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewpager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mViewpager.setOffscreenPageLimit(4);
    }

}
