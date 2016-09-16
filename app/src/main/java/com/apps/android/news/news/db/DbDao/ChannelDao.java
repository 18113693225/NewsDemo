package com.apps.android.news.news.db.DbDao;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.apps.android.news.news.db.DBCipherHelper;
import com.apps.android.news.news.db.DBCipherManager;
import com.apps.android.news.news.model.Channels;
import com.apps.android.news.news.model.Table;
import com.apps.android.news.news.utils.util.StringUtils;

import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/9/13.
 */
public class ChannelDao {

    private String TAG = "ChannelDao";

    private DBCipherManager db;
    private String table = "channel";
    private static final String SELECTED = "1";
    private static final String UNSELECTED = "0";

    public ChannelDao(Context context) {
        db = DBCipherManager.getInstance(context);
    }

    /**
     * 获取用户关注频道
     *
     * @return
     */
    public ArrayList<Table> getUserChannels() {
        return getChannels(SELECTED);
    }

    /**
     * 获取所有频道
     *
     * @return
     */
    public ArrayList<Table> getChannels() {
        return getChannels(null);
    }

    /**
     * 更新用户关注频道
     *
     * @param array
     */
    public void updateUserChannels(JSONArray array) {
        db.deleteData("channel", " isSelected = '" + SELECTED + "'");
        db.insertDatasByTransaction("channel", array);
    }


    /**
     * 更新整个频道数据
     */
    public void initChannels(List<Table> array) {
        //获取写数据库
        SQLiteDatabase sdb = db.getDbHelper().getWritableDatabase(DBCipherHelper.DB_PWD);
        sdb.beginTransaction(); //手动设置开始事务
        db.deleteDatas(table);
        try {
            //批量处理操作
            int count = array.size();
            ContentValues cv = null;
            Table t = null;
            for (int i = 0; i < count; i++) {
                //生成要修改或者插入的键值
                t = array.get(i);
                cv = new ContentValues();
                cv.put("id", t.id);
                cv.put("name", t.name);
                cv.put("orderId", t.orderId);
                cv.put("isSelected", t.isSelected);
                // insert 操作
                sdb.insert(table, null, cv);
            }
            sdb.setTransactionSuccessful(); //设置事务处理成功，不设置会自动回滚不提交
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        } finally {
            sdb.endTransaction(); //处理完成
            //关闭数据库
            sdb.close();
        }
    }

    private ArrayList<Table> getChannels(String selectedValue) {

        String sql = "select * from " + table;
        if (StringUtils.isNotBlank(selectedValue)) {
            sql += "  where isSelected = '" + selectedValue + "'";
        }
        //获取可读数据库
        SQLiteDatabase sdb = db.getDbHelper().getReadableDatabase(DBCipherHelper.DB_PWD);

        //查询数据库
        Cursor cursor = null;
        ArrayList<Table> models = null;
        Table model = null;
        try {
            cursor = sdb.rawQuery(sql, null);
            models = new ArrayList<Table>();
            while (cursor.moveToNext()) {
                model = new Table();
                model.id = cursor.getString(cursor.getColumnIndex("id"));
                model.name = cursor.getString(cursor.getColumnIndex("name"));
                model.orderId = cursor.getString(cursor.getColumnIndex("orderId"));
                model.isSelected = cursor.getString(cursor.getColumnIndex("isSelected"));
                models.add(model);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLException e) {
            Log.e(TAG, "getUserChannels" + e.toString());
        } finally {
            //关闭数据库
            sdb.close();
        }
        return models;
    }


}
