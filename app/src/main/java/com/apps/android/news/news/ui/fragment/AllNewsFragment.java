package com.apps.android.news.news.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.model.Table;
import com.smartydroid.android.starter.kit.app.StarterPagedFragment;

import java.util.ArrayList;

import butterknife.Bind;
import retrofit2.Call;
import support.ui.adapters.EasyRecyclerAdapter;

/**
 * Created by android on 2016/9/13.
 */
public class AllNewsFragment extends StarterPagedFragment<Table> {

    @Bind(R.id.news_name)
    TextView textView;
    Bundle args;

    @Override
    public Call<ArrayList<Table>> paginate(int page, int perPage) {
        return null;
    }

    @Override
    public Object getKeyForData(Table item) {
        return null;
    }

    @Override
    public void bindViewHolders(EasyRecyclerAdapter adapter) {

    }
}
