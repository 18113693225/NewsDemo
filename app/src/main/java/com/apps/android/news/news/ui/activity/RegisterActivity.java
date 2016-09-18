package com.apps.android.news.news.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.apps.android.news.news.R;

import butterknife.Bind;

/**
 * Created by android on 2016/9/18.
 */
public class RegisterActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_center_tv)
    TextView toolbar_center_tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setUpToolbar();
    }

    private void setUpToolbar() {
        toolbar.setTitle("");
        toolbar_center_tv.setText("获取验证码");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
    private void initView(){

    }
}
