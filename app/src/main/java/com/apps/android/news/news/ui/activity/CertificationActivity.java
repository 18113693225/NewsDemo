package com.apps.android.news.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.apps.android.news.news.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import mediapicker.MediaOptions;
import mediapicker.MediaItem;
import support.ui.utilities.ToastUtils;

import static mediapicker.activities.MediaPickerActivity.*;

/**
 * Created by android on 2016/9/18.
 */
public class CertificationActivity extends BaseActivity {

    public static final int REQUEST_MEDIA = 100;
    public ArrayList<MediaItem> mMediaSelectedList = new ArrayList<>();
    String name;
    String location;
    @Bind(R.id.account_info_tv)
    TextView accountName;
    @Bind(R.id.toolBar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_center_tv)
    TextView toolbar_center_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        setUpToolbar();
    }

    private void setUpToolbar() {
        toolbar.setTitle("");
        toolbar_center_tv.setText("资料申请");
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

    @OnClick({R.id.info_rl, R.id.image_rl, R.id.area_rl, R.id.commit_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_rl:
                showChangeNameDialog();
                break;
            case R.id.image_rl:
                showMediaPicker();
                break;
            case R.id.area_rl:

                break;
            case R.id.commit_bt:

                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_MEDIA) {
                mMediaSelectedList.clear();
                mMediaSelectedList.addAll(getMediaItemSelected(data));
                MediaItem mediaItem = mMediaSelectedList.get(0);
                location = mediaItem.getPathOrigin(CertificationActivity.this);

                mMediaSelectedList.clear();
            }
        }
    }

    private void showMediaPicker() {
        MediaOptions.Builder builder = new MediaOptions.Builder();
        MediaOptions options = builder.canSelectMultiPhoto(false)
                .setIsCropped(false)
                .setMediaListSelected(mMediaSelectedList)
                .setImageSize(1)
                .build();
        open(CertificationActivity.this, REQUEST_MEDIA, options, false);
    }


    private void showChangeNameDialog() {
        new MaterialDialog.Builder(this).title("账户信息")
                .input("请输入账户信息", "", false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {

                    }
                })
                .negativeText("取消")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        if (dialog.getInputEditText().getText().toString().length() > 20) {
                            ToastUtils.toast(CertificationActivity.this, "账户信息长度不能大于8个字符");
                        } else {
                            name = dialog.getInputEditText().getText().toString();
                            accountName.setText(name);
                            dialog.dismiss();
                        }
                    }
                })
                .autoDismiss(false)
                .build()
                .show();
    }

}
