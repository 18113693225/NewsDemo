package com.apps.android.news.news.db.greendao.dao;

import android.content.Context;

import com.apps.android.news.news.db.DBManager;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.db.greendao.gen.LableDao;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public class LableManager {

    private static LableManager mInstance;
    private static LableDao lableDao;
    private Context context;
    private LableManager(Context context){
        this.context = context;
        lableDao = DBManager.getInstance(context).getDaoSession().getLableDao();
    }

    public static LableManager getInstance(Context context){
        if (mInstance == null) {
            synchronized (LableManager.class) {
                if (mInstance == null) {
                    mInstance = new LableManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取用户频道
     * @return
     */
    public List<Lable> getUserLables(){
        List<Lable> userList = lableDao.queryBuilder()
                                       .where(LableDao.Properties.IsSelected.eq("1"))
                                       .list();
        return userList;
    }

    /**
     * 获取所有频道
     * @return
     */
    public List<Lable> getLables(){
        return lableDao.queryBuilder().list();
    }

    /**
     * 初始化测试数据
     */
    public void initTestData(){
        long count = lableDao.count();
        if(count==0){
            lableDao.insertInTx( Lable.getTestData());
        }
        getUserLables();
        getLables();
    }

}
