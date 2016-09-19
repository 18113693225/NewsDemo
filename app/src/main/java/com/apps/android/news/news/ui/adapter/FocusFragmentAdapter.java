package com.apps.android.news.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.apps.android.news.news.ui.fragment.CollectionFragment;
import com.apps.android.news.news.ui.fragment.CommentsFragment;
import com.apps.android.news.news.ui.fragment.FirmFragment;
import com.apps.android.news.news.ui.fragment.ForwardingFragment;


/**
 * Created by android on 2016/9/19.
 */
public class FocusFragmentAdapter extends FragmentPagerAdapter {


    private final static String TAB_TITLE[] = {"收藏", "转发", "评论", "企业"};
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;


    public FocusFragmentAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new CollectionFragment();
        fragment2 = new ForwardingFragment();
        fragment3 = new CommentsFragment();
        fragment4 = new FirmFragment();

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
            case 2:
                fragment = fragment3;
                break;
            case 3:
                fragment = fragment4;
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
