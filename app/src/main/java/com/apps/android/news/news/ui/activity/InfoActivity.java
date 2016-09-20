package com.apps.android.news.news.ui.activity;


import android.os.Bundle;
import android.view.MenuItem;

import com.apps.android.news.news.R;
import com.apps.android.news.news.api.service.DSFAServiceManager;
import com.apps.android.news.news.db.greendao.dao.LableManager;
import com.apps.android.news.news.model.DSFAModel;

/**
 * Created by android on 2016/9/18.
 */
public class InfoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        initLabel();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }


    private void initLabel() {
        DSFAServiceManager.getLables(new DSFAServiceManager.DSFACallback() {
            @Override
            public void success(DSFAModel dsfaModel) {
                LableManager.getInstance(InfoActivity.this).saveLables(dsfaModel.getLables());
            }

            @Override
            public void error(DSFAServiceManager.DSFAError error) {

            }
        });
    }


}
