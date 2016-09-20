package com.apps.android.news.news.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.android.news.news.Navigator;
import com.apps.android.news.news.R;
import com.apps.android.news.news.api.service.DSFAServiceManager;
import com.apps.android.news.news.db.greendao.dao.CustomerManager;
import com.apps.android.news.news.db.greendao.dao.LableManager;
import com.apps.android.news.news.db.greendao.entity.Customer;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.model.DSFAModel;
import com.apps.android.news.news.ui.widget.TextRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * Created by android on 2016/9/13.
 */
public class IntroActivity extends BaseActivity implements TextRecyclerView.OnItemClickListener {
    @Bind(R.id.all_table_rc)
    TextRecyclerView mRecyclerView;
    RelativeLayout bg;
    TextView name;

    List<Lable> data;
    List<Lable> selectData = new ArrayList<Lable>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
    }


    private void init() {
        data = LableManager.getInstance(this).getLables();
        mRecyclerView.setData(data, this);
    }


    @OnClick({R.id.register_bt, R.id.look_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_bt:
                if (selectData.size() < 6) {
                    Toast.makeText(IntroActivity.this, "请选择6个以上的栏目", Toast.LENGTH_SHORT).show();
                    return;
                }
                Navigator.startRegisterActivity(IntroActivity.this);
                break;
            case R.id.look_bt:
                showHud();
                look();
                break;
            default:
                break;
        }
    }

    private void look() {
        if (selectData.size() < 6) {
            dismissHud();
            Toast.makeText(IntroActivity.this, "请选择6个以上的栏目", Toast.LENGTH_SHORT).show();
            return;
        }
        DSFAServiceManager.initUser(selectData, new DSFAServiceManager.DSFACallback() {
            @Override
            public void success(DSFAModel dsfaModel) {
                dismissHud();
                Customer user = dsfaModel.getUser();
                CustomerManager.getInstance(IntroActivity.this).saveCustomer(user);
                Navigator.startMainActivity(IntroActivity.this);
                finish();
            }

            @Override
            public void error(DSFAServiceManager.DSFAError error) {
                dismissHud();
                Toast.makeText(IntroActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(View v, int position) {

        bg = (RelativeLayout) v.findViewById(R.id.text_rl);
        name = (TextView) v.findViewById(R.id.label_name);
        Lable l = data.get(position);
        if (selectData.contains(l)) {
            selectData.remove(l);
            bg.setBackgroundColor(getResources().getColor((R.color.white)));
            name.setTextColor(getResources().getColor((R.color.title)));
        } else {
            selectData.add(l);
            bg.setBackgroundColor(getResources().getColor((R.color.color_bg_bt)));
            name.setTextColor(getResources().getColor((R.color.white)));
        }
    }


}
