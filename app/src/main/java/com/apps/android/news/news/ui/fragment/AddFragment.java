package com.apps.android.news.news.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.news_bt, R.id.sale_bt, R.id.thing_bt, R.id.seek_bt, R.id.activity_bt})
    public void onClic(View view) {
        switch (view.getId()) {
            case R.id.news_bt:
                Navigator.startReleaseNewsActivity(getActivity());
                break;
            case R.id.sale_bt:
                Navigator.startReleaseInfoActivity(getActivity());
                break;
            case R.id.thing_bt:
                Navigator.startReleaseInfoActivity(getActivity());
                break;
            case R.id.seek_bt:
                Navigator.startReleaseInfoActivity(getActivity());
                break;
            case R.id.activity_bt:
                Navigator.startReleaseNewsActivity(getActivity());
                break;
            default:
                break;
        }
    }

}
