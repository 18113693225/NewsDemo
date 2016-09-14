package com.apps.android.news.news.db;

import android.content.Context;
import android.util.Log;

import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/13.
 */
public class DBCipherHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "news_db";//数据库名字
    public static final String DB_PWD = "dreamsoft";//数据库密码
    private static final int DB_VERSION = 1;   // 数据库版本

    public DBCipherHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //不可忽略的 进行so库加载
        SQLiteDatabase.loadLibs(context);
    }

    public DBCipherHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * 创建数据库
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        createChannelTable(db);
    }

    /**
     * 创建频道表
     *
     * @param db
     */
    private void createChannelTable(SQLiteDatabase db) {
        String sql = "create table IF NOT EXISTS  channel( " +
                "_ID integer primary key autoincrement, " +
                "id varchar(50), " +
                "name varchar(50), " +
                "orderId integer, " +
                "isSelected varchar(2) " +
                ")";
        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG, "onCreate Error" + e.toString());
            return;
        }
    }

    /**
     * 数据库升级
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
