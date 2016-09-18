package com.apps.android.news.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.apps.android.news.news.R;

import java.util.ArrayList;

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
    public String name;

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

    @OnClick({R.id.info_rl, R.id.image_rl, R.id.area_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_rl:
                showChangeNameDialog();
                break;
            case R.id.image1:
                showMediaPicker();
                break;
            case R.id.area_rl:
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
                String location = mediaItem.getPathOrigin(CertificationActivity.this);

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
        open(this, REQUEST_MEDIA, options, false);
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
                            dialog.dismiss();
                        }
                    }
                })
                .autoDismiss(false)
                .build()
                .show();
    }

}
