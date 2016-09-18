package com.apps.android.news.news.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.apps.android.news.news.R;

/**
 * Created by android on 2016/9/18.
 */
public class CertificationActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
