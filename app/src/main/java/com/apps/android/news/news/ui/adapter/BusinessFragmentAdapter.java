package com.apps.android.news.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.apps.android.news.news.ui.fragment.DirectoryFragment;
import com.apps.android.news.news.ui.fragment.OfferFragment;

/**
 * Created by android on 2016/9/19.
 */
public class BusinessFragmentAdapter extends FragmentPagerAdapter {
    private final static String TAB_TITLE[] = {"供需", "名录"};
    private Fragment fragment1;
    private Fragment fragment2;


    public BusinessFragmentAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new OfferFragment();
        fragment2 = new DirectoryFragment();

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = fragment1;
                break;
            case 1:
                fragment = fragment2;
                break;
            default:
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return TAB_TITLE.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLE[position];
    }

}
