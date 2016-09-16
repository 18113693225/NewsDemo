package com.apps.android.news.news.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

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
        initChannelData(db);
    }

    private void initChannelData(SQLiteDatabase db){
        JSONArray d = new JSONArray();
        d.put(initChannelData("a","推荐", "0", "1"));
        d.put(initChannelData("b","产业链","1", "1"));
        d.put(initChannelData("c","政策", "2", "1"));
        d.put(initChannelData("d","上海", "3", "1"));
        d.put(initChannelData("e","人才", "4", "1"));
        d.put(initChannelData("f","要闻", "5", "1"));
        d.put(initChannelData("g","军事", "6", "1"));
        d.put(initChannelData("h","财经", "7", "1"));
        d.put(initChannelData("i","汽车", "8", "1"));
        d.put(initChannelData("j","农业", "9", "0"));
        d.put(initChannelData("k","非农","10", "0"));
        d.put(initChannelData("m","漫画", "11", "0"));
        d.put(initChannelData("l","IT", "12", "0"));
        insertDatasByTransaction("channel",d);
    }

    private JSONObject initChannelData(String id,String name,String orderId,String isSelected){
        JSONObject data = new JSONObject();
        try {
            data.put("name",name);
            data.put("id",id);
            data.put("orderId",orderId);
            data.put("isSelected",isSelected);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 开启事务批量插入
     *
     * @param table 表名
     * @param datas 数据
     */
    private void insertDatasByTransaction(String table, JSONArray datas) {
        //获取写数据库
        SQLiteDatabase db = this.getWritableDatabase(DBCipherHelper.DB_PWD);
        db.beginTransaction();  //手动设置开始事务
        try {
            //批量处理操作
            int count = datas.length();
            ContentValues cv = null;
            JSONObject data = null;
            for (int i = 0; i < count; i++) {
                //生成要修改或者插入的键值
                data = datas.getJSONObject(i);
                cv = new ContentValues();
                Iterator<String> keys = data.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    try {
                        cv.put(key, data.getString(key));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                // insert 操作
                db.insert(table, null, cv);
                Log.e(TAG, "insertDatasByTransaction");
            }
            db.setTransactionSuccessful(); //设置事务处理成功，不设置会自动回滚不提交
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        } finally {
            db.endTransaction(); //处理完成
            //关闭数据库
            db.close();
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
