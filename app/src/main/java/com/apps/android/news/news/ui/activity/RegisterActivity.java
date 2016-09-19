package com.apps.android.news.news.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;
import com.apps.android.news.news.api.service.DSFAServiceManager;
import com.apps.android.news.news.db.DBManager;
import com.apps.android.news.news.db.greendao.dao.CustomerManager;
import com.apps.android.news.news.db.greendao.entity.Customer;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.model.DSFAModel;
import com.apps.android.news.news.utils.tool.TimerCount;

import java.util.ArrayList;
import java.util.List;

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
    private List<Lable> lables = new ArrayList<Lable>();

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

    @OnClick({R.id.code_bt, R.id.next_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.code_bt:
                showHud("获取验证码");
                getCode();
                break;
            case R.id.next_bt:
                showHud("注册中");
                next();
                break;
            default:
                break;
        }
    }

    private void getCode() {
        String username = number.getText().toString();
        if (username.length() != 11) {
            dismissHud();
            Toast.makeText(RegisterActivity.this, "手机号不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        DSFAServiceManager.getAuthCode(username, new DSFAServiceManager.DSFACallback() {
            @Override
            public void success(DSFAModel dsfaModel) {
                dismissHud();
                boolean flag = dsfaModel.getState();
                if (flag) {
                    TimerCount timer = new TimerCount(60000, 1000, code_bt);
                    timer.start();
                } else {
                    Toast.makeText(RegisterActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void error(DSFAServiceManager.DSFAError error) {
                dismissHud();
                Toast.makeText(RegisterActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void next() {
        String username = number.getText().toString();
        String userCode = code.getText().toString();
        if (userCode.length() != 6) {
            dismissHud();
            Toast.makeText(RegisterActivity.this, "验证码不正确", Toast.LENGTH_SHORT).show();
            return;
        }

        DSFAServiceManager.valiAuthCode(username, userCode, lables, new DSFAServiceManager.DSFACallback() {
            @Override
            public void success(DSFAModel dsfaModel) {
                dismissHud();
                boolean flag = dsfaModel.getValiCodeState();
                if (flag) {
                    Customer user = dsfaModel.getUser();
                    CustomerManager.getInstance(RegisterActivity.this).saveCustomer(user);
                    Navigator.startMainActivity(RegisterActivity.this);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void error(DSFAServiceManager.DSFAError error) {
                dismissHud();
                Toast.makeText(RegisterActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
