package com.apps.android.news.news.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;
import com.apps.android.news.news.db.greendao.dao.LableManager;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.ui.widget.TextRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import info.hoang8f.widget.FButton;
import retrofit2.Call;

/**
 * Created by android on 2016/9/13.
 */
public class IntroActivity extends BaseActivity {
    @Bind(R.id.all_table_rc)
    TextRecyclerView mRecyclerView;
    List<Lable> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
    }


    private void init() {
        data = LableManager.getInstance(this).getLables();
        mRecyclerView.setData(data);
    }


    @OnClick({R.id.register_bt, R.id.look_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_bt:
                Navigator.startRegisterActivity(IntroActivity.this);
                break;
            case R.id.look_bt:
                Navigator.startMainActivity(IntroActivity.this);
                finish();
                break;
            default:
                break;
        }
    }


}
