package com.apps.android.news.news.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by android on 2016/9/16.
 */
public class AccountManagerFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_manager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.user_info_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_info_rl:
                Navigator.startIntroActivity(getActivity());
                break;
            default:
                break;
        }
    }


}
