package com.apps.android.news.news.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.android.news.news.R;
import com.apps.android.news.news.utils.tool.TimerCount;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by android on 2016/9/18.
 */
public class RegisterActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_center_tv)
    TextView toolbar_center_tv;
    @Bind(R.id.userName)
    EditText number;
    @Bind(R.id.userCode)
    EditText code;
    @Bind(R.id.code_bt)
    Button code_bt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

    @OnClick({R.id.code_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.code_bt:
                getCode();
                break;
            default:
                break;
        }
    }

    private void getCode() {
        String username = number.getText().toString();
        if (username.length() != 11) {
            Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        TimerCount timer = new TimerCount(60000, 1000, code_bt);
        timer.start();
    }
}
