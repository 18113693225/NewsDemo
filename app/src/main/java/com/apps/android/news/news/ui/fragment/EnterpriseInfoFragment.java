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
public class EnterpriseInfoFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enterprise_info, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.certification_rl, R.id.info_rl, R.id.door_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.certification_rl:
                Navigator.startCertificationActivity(getActivity());
                break;
            case R.id.info_rl:
                break;
            case R.id.door_rl:
                break;
            default:
                break;
        }
    }


}
