package com.apps.android.news.news.utils.tool;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by lj on 2016/9/13.
 */
public class WindowsTool {
    /**
     * 获取屏幕的宽度
     */

    public final static int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
