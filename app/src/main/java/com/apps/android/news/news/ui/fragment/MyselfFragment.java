package com.apps.android.news.news.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.android.news.news.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyselfFragment extends Fragment {
    public static final int SHOW_ACCOUNT_MANAGER = 0;
    public static final int SHOW_ENTERPRISE_IN = 1;
    public static final int SHOW_APPLICATION_SET = 2;

    @Bind(R.id.account_manager_iv)
    ImageView account_iv;
    @Bind(R.id.enterprise_info_iv)
    ImageView enterprise_iv;
    @Bind(R.id.application_set_iv)
    ImageView set_iv;

    @Bind(R.id.account_manager_tv)
    TextView account_tv;
    @Bind(R.id.enterprise_info_tv)
    TextView enterprise_tv;
    @Bind(R.id.application_set_tv)
    TextView set_tv;

    Fragment manager;
    Fragment info;
    Fragment sets;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }


    private void initView() {
        restartButton();
        initFragment(SHOW_ACCOUNT_MANAGER);
    }

    public void restartButton() {
        account_iv.setImageResource(R.mipmap.ic_account_manager_black);
        enterprise_iv.setImageResource(R.mipmap.ic_enterprise_info_black);
        set_iv.setImageResource(R.mipmap.ic_application_set_black);
        account_tv.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
        enterprise_tv.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
        set_tv.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));

    }

    private void initFragment(int witchPage) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (witchPage) {
            case SHOW_ACCOUNT_MANAGER:
                if (manager == null) {
                    manager = new AccountManagerFragment();
                    ft.add(R.id.myself_fl, manager);
                } else {
                    ft.show(manager);
                }
                account_iv.setImageResource(R.mipmap.ic_account_manager);
                account_tv.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            case SHOW_ENTERPRISE_IN:
                if (info == null) {
                    info = new EnterpriseInfoFragment();
                    ft.add(R.id.myself_fl, info);
                } else {
                    ft.show(info);
                }
                enterprise_iv.setImageResource(R.mipmap.ic_enterprise_info);
                enterprise_tv.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            case SHOW_APPLICATION_SET:
                if (sets == null) {
                    sets = new ApplicationSetFragment();
                    ft.add(R.id.myself_fl, sets);
                } else {
                    ft.show(sets);
                }
                set_iv.setImageResource(R.mipmap.ic_application_set);
                set_tv.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            default:
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (manager != null) {
            transaction.hide(manager);
        }
        if (info != null) {
            transaction.hide(info);
        }
        if (sets != null) {
            transaction.hide(sets);
        }
    }

    @OnClick({R.id.menu_account_manager, R.id.menu_enterprise_info, R.id.menu_application_set})
    public void MenuClick(View view) {
        restartButton();
        int id = view.getId();
        switch (id) {
            case R.id.menu_account_manager:
                initFragment(SHOW_ACCOUNT_MANAGER);
                break;
            case R.id.menu_enterprise_info:
                initFragment(SHOW_ENTERPRISE_IN);
                break;
            case R.id.menu_application_set:
                initFragment(SHOW_APPLICATION_SET);
                break;
            default:
                break;
        }
    }
}
