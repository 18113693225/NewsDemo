package com.apps.android.news.news.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.android.news.news.R;
import com.apps.android.news.news.model.Table;
import com.smartydroid.android.starter.kit.app.StarterPagedFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public Call<ArrayList<Table>> paginate(int page, int perPage) {
        return null;
    }

    @Override
    public Object getKeyForData(Table item) {
        return item.index;
    }

    @Override
    public void bindViewHolders(EasyRecyclerAdapter adapter) {

    }
}
