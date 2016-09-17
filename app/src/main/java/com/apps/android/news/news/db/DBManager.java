package com.apps.android.news.news.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apps.android.news.news.db.greendao.gen.DaoMaster;
import com.apps.android.news.news.db.greendao.gen.DaoSession;

/**
 * Created by Administrator on 2016/9/16.
 */
public class DBManager {
    private final static String dbName = "news_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    public DaoSession getDaoSession(){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        return daoMaster.newSession();
    }
}
