package com.apps.android.news.news.utils.util;

import com.apps.android.news.news.BuildConfig;

/**
 * Created by android on 2016/9/13.
 */
public class ErrorUtils {
    public static void handleException(Exception e) {
        if (BuildConfig.DEBUG) {
            e.printStackTrace();
        } else {
        }
    }

    public static void handleMessage(String message) {
        if (BuildConfig.DEBUG) {
        } else {
        }
    }

}
