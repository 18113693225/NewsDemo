package com.apps.android.news.news.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Administrator on 2016/9/13.
 */
public class DBCipherManager {
    private static final String TAG = "DatabaseManager";
    // 静态引用
    private volatile static DBCipherManager mInstance;
    // DatabaseHelper
    private DBCipherHelper dbHelper;

    private DBCipherManager(Context context) {
        dbHelper = new DBCipherHelper(context.getApplicationContext());
    }

    public DBCipherHelper getDbHelper(){
        return this.dbHelper;
    }
    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBCipherManager getInstance(Context context) {
        DBCipherManager inst = mInstance;
        if (inst == null) {
            synchronized (DBCipherManager.class) {
                inst = mInstance;
                if (inst == null) {
                    inst = new DBCipherManager(context);
                    mInstance = inst;
                }
            }
        }
        return inst;
    }

    /**
     * 插入数据
     */
    public void insertData(String table, JSONObject data) {
        //获取写数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase(DBCipherHelper.DB_PWD);
        //生成要修改或者插入的键值
        ContentValues cv = new ContentValues();
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
        //关闭数据库
        db.close();
    }

    /**
     * 开启事务批量插入
     *
     * @param table 表名
     * @param datas 数据
     */
    public void insertDatasByTransaction(String table, JSONArray datas) {
        //获取写数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase(DBCipherHelper.DB_PWD);
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
     * 删除数据
     *
     * @param table
     * @param where
     */
    public void deleteData(String table, String where) {
      /*  //生成条件语句
        StringBuffer whereBuffer = new StringBuffer();
        whereBuffer.append(DBCipherHelper.FIELD_NAME).append(" = ").append("'").append(name).append("'");
        //获取写数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase(DBCipherHelper.DB_PWD);
        // delete 操作
        db.delete(DBCipherHelper.TABLE_NAME, whereBuffer.toString(), null);
        //关闭数据库
        db.close();*/
    }

    /**
     * 删除所有数据
     *
     * @param table
     */
    public void deleteDatas(String table) {
        String sql = "delete from " + table;
        execSQL(sql);
    }

    /**
     * 更新数据
     */
    public void updateData(String name) {
       /* //生成条件语句
        StringBuffer whereBuffer = new StringBuffer();
        whereBuffer.append(DBCipherHelper.FIELD_NAME).append(" = ").append("'").append(name).append("'");
        //生成要修改或者插入的键值
        ContentValues cv = new ContentValues();
        cv.put(DBCipherHelper.FIELD_NAME, name+name);
        //获取写数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase(DBCipherHelper.DB_PWD);
        // update 操作
        db.update(DBCipherHelper.TABLE_NAME, cv, whereBuffer.toString(), null);
        //关闭数据库
        db.close();*/
    }

    /**
     * 指定条件查询数据
     */
    public JSONArray queryDatas(String sql) {
        //获取可读数据库
        SQLiteDatabase db = dbHelper.getReadableDatabase(DBCipherHelper.DB_PWD);
        //查询数据库
        Cursor cursor = null;
        JSONArray array = new JSONArray();
        try {
            cursor = db.rawQuery(sql, null);
            JSONObject data = null;
            while (cursor.moveToNext()) {
                int count = cursor.getColumnCount();
                data = new JSONObject();
                for (int i = 0; i < count; i++) {
                    String columName = cursor.getColumnName(i);
                    String value = cursor.getString(i);
                    data.put(columName, value);
                }
                array.put(data);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLException e) {
            Log.e(TAG, "queryDatas" + e.toString());
        } catch (JSONException e) {
            Log.e(TAG, "queryDatas" + e.toString());
            e.printStackTrace();
        } finally {
            //关闭数据库
            db.close();
        }
        return array;
    }

    /**
     * 查询全部数据
     */
    public void queryDatas() {
      /*  //指定要查询的是哪几列数据
        String[] columns = {DBCipherHelper.FIELD_NAME};
        //获取可读数据库
        SQLiteDatabase db = dbHelper.getReadableDatabase(DBCipherHelper.DB_PWD);
        //查询数据库
        Cursor cursor = null;
        try {
            cursor = db.query(DBCipherHelper.TABLE_NAME, columns, null, null, null, null, null);//获取数据游标
            while (cursor.moveToNext()) {
                int count = cursor.getColumnCount();
                String columeName = cursor.getColumnName(0);//获取表结构列名
                String  name = cursor.getString(0);//获取表结构列数据
                Log.e(TAG, "count = " + count + " columName = " + columeName + "  name =  " +name);
            }
            //关闭游标防止内存泄漏
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLException e) {
            Log.e(TAG, "queryDatas" + e.toString());
        }
        //关闭数据库
        db.close();*/
    }

    /**
     * 执行sql语句
     */
    private void execSQL(String sql) {
        //获取写数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase(DBCipherHelper.DB_PWD);
        //直接执行sql语句
        db.execSQL(sql);//或者
        //关闭数据库
        db.close();
    }

}
