package com.apps.android.news.news.db.DbDao;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.apps.android.news.news.api.ApiService;
import com.apps.android.news.news.db.DBCipherHelper;
import com.apps.android.news.news.db.DBCipherManager;
import com.apps.android.news.news.model.Table;
import com.apps.android.news.news.model.User;

import net.sqlcipher.database.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

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
    public JSONArray getUserChannels(){
        return  db.queryDatas("select * from "+table+" where isSelected = '"+SELECTED+"'");
    }

    /**
     * 获取所有频道
     *
     * @return
     */

    public JSONArray getChannels(){
        return  db.queryDatas("select * from "+table);
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
        db.deleteDatas(table);
        //获取写数据库
        SQLiteDatabase sdb = db.getDbHelper().getWritableDatabase(DBCipherHelper.DB_PWD);
        sdb.beginTransaction(); //手动设置开始事务
        try {
            //批量处理操作
            int count = array.size();
            ContentValues cv = null;
            Table t  = null;
            for (int i = 0; i < count; i++) {
                //生成要修改或者插入的键值
                t = array.get(i);
                cv = new ContentValues();
                cv.put("id",t.id);
                cv.put("name",t.name);
                cv.put("orderId",t.orderId);
                cv.put("isSelected",t.isSelected);
                // insert 操作
                sdb.insert(table, null, cv);
                Log.e(TAG, "insertDatasByTransaction");
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


}
