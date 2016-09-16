package com.apps.android.news.news.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.android.news.news.R;
import com.apps.android.news.news.ui.fragment.AddFragment;
import com.apps.android.news.news.ui.fragment.BusinessFragment;
import com.apps.android.news.news.ui.fragment.FocusFragment;
import com.apps.android.news.news.ui.fragment.HomeFragment;
import com.apps.android.news.news.ui.fragment.MyselfFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页
 */
public class MainActivity extends FragmentActivity {
    public static final int SHOW_HOME = 0;
    public static final int SHOW_BUSINESS = 1;
    public static final int SHOW_FOCUS = 2;
    public static final int SHOW_MYSELF = 3;
    public static final int SHOW_ADD = 4;

    //底部菜单图片
    @Bind(R.id.menu_img_home)
    ImageView imgHome;
    @Bind(R.id.menu_img_business)
    ImageView imgBusiness;
    @Bind(R.id.menu_img_focus)
    ImageView imgFocus;
    @Bind(R.id.menu_img_myself)
    ImageView imgMyself;
    @Bind(R.id.menu_img_add)
    ImageView imgAdd;

    //底部菜单文字
    @Bind(R.id.menu_text_home)
    TextView textHome;
    @Bind(R.id.menu_text_business)
    TextView textBusiness;
    @Bind(R.id.menu_text_focus)
    TextView textFocus;
    @Bind(R.id.menu_text_myself)
    TextView textMyself;
    @Bind(R.id.menu_text_add)
    TextView textAdd;


    Fragment homeFragment;
    Fragment businessFragment;
    Fragment focusFragment;
    Fragment myselfFragment;
    Fragment addFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        restartButton();
        initFragment(SHOW_HOME);
    }

    public void restartButton() {
        imgHome.setImageResource(R.mipmap.home_normal);
        imgBusiness.setImageResource(R.mipmap.business_normal);
        imgFocus.setImageResource(R.mipmap.focus_normal);
        imgMyself.setImageResource(R.mipmap.myself_normal);
        imgAdd.setImageResource(R.mipmap.add_normal);
        textHome.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
        textBusiness.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
        textFocus.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
        textMyself.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
        textAdd.setTextColor(getResources().getColor(R.color.menu_btn_text_normal));
    }

    private void initFragment(int witchPage) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (witchPage) {
            case SHOW_HOME:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.fl_content, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                imgHome.setImageResource(R.mipmap.home_pressed);
                textHome.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            case SHOW_BUSINESS:
                if (businessFragment == null) {
                    businessFragment = new BusinessFragment();
                    ft.add(R.id.fl_content, businessFragment);
                } else {
                    ft.show(businessFragment);
                }
                imgBusiness.setImageResource(R.mipmap.business_pressed);
                textBusiness.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            case SHOW_FOCUS:
                if (focusFragment == null) {
                    focusFragment = new FocusFragment();
                    ft.add(R.id.fl_content, focusFragment);
                } else {
                    ft.show(focusFragment);
                }
                imgFocus.setImageResource(R.mipmap.focus_pressed);
                textFocus.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            case SHOW_MYSELF:
                if (myselfFragment == null) {
                    myselfFragment = new MyselfFragment();
                    ft.add(R.id.fl_content, myselfFragment);
                } else {
                    ft.show(myselfFragment);
                }
                imgMyself.setImageResource(R.mipmap.myself_pressed);
                textMyself.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            case SHOW_ADD:
                if (addFragment == null) {
                    addFragment = new AddFragment();
                    ft.add(R.id.fl_content, addFragment);
                } else {
                    ft.show(addFragment);
                }
                imgAdd.setImageResource(R.mipmap.add_pressed);
                textAdd.setTextColor(getResources().getColor(R.color.menu_btn_text_pressed));
                break;
            default:
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (businessFragment != null) {
            transaction.hide(businessFragment);
        }
        if (focusFragment != null) {
            transaction.hide(focusFragment);
        }
        if (myselfFragment != null) {
            transaction.hide(myselfFragment);
        }
        if (addFragment != null) {
            transaction.hide(addFragment);
        }
    }

    @OnClick({R.id.fl_home, R.id.fl_business, R.id.fl_focus, R.id.fl_myself, R.id.fl_add})
    public void MenuClick(View view) {
        restartButton();
        int id = view.getId();
        switch (id) {
            case R.id.fl_home:
                initFragment(SHOW_HOME);
                break;
            case R.id.fl_business:
                initFragment(SHOW_BUSINESS);
                break;
            case R.id.fl_focus:
                initFragment(SHOW_FOCUS);
                break;
            case R.id.fl_myself:
                initFragment(SHOW_MYSELF);
                break;
            case R.id.fl_add:
                initFragment(SHOW_ADD);
                break;
            default:
                break;
        }
    }


    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "在按一次退出",
                        Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        //拦截MENU按钮点击事件，让他无任何操作
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
