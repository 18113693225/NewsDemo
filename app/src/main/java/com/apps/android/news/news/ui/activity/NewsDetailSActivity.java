package com.apps.android.news.news.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.apps.android.news.news.R;

import butterknife.Bind;


/**
 * Created by android on 2016/9/18.
 */
public class NewsDetailSActivity extends BaseActivity {
    @Bind(R.id.news_web)
    WebView mWebView;
    @Bind(R.id.prgBar)
    ProgressBar mPrgBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
            } else {
                finish();
            }

        }
        return true;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    if (mPrgBar != null) {
                        mPrgBar.setVisibility(View.GONE);
                        mPrgBar.setProgress(0);
                    }
                } else {
                    if (mPrgBar != null) {
                        if (View.GONE == mPrgBar.getVisibility()) {
                            mPrgBar.setVisibility(View.VISIBLE);
                        }
                        mPrgBar.setProgress(newProgress);
                    }
                }
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setDefaultTextEncodingName("UTF-8");
        mWebSettings.setBuiltInZoomControls(false);
        mWebView.loadUrl(url);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.removeAllViews();
            mWebView.destroy();
        }
    }
}
