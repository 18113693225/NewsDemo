package com.apps.android.news.news.db.greendao.dao;

import android.content.Context;

import com.apps.android.news.news.db.DBManager;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.db.greendao.gen.LableDao;
import com.apps.android.news.news.model.User;

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
     * 更新  所有频道
     * @param labelList
     */
    public void saveLables(final List<Lable> labelList){
        final List<Lable> userLableList = getUserLables();
        lableDao.deleteAll();
        lableDao.insertInTx(labelList);
        if(userLableList==null) return;
        lableDao.getSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (Lable lable: userLableList) {
                    Lable databaseLable = lableDao.queryBuilder().where(LableDao.Properties.Id.eq(lable.getId())).unique();
                    if(databaseLable!=null){
                        databaseLable.setIsSelected("1");
                        lableDao.update(databaseLable);
                    }
                }
            }
        });
    }

    /**
     * 保存用户  所关注的频道
     * @param lableList
     */
    public void saveUserLables(final List<Lable> lableList){
        lableDao.getSession().getDatabase().execSQL("UPDATE FROM LABLE SET ISSELECTED = '0'");
        lableDao.getSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (Lable lable: lableList) {
                    Lable databaseLable = lableDao.queryBuilder().where(LableDao.Properties.Id.eq(lable.getId())).unique();
                    if(databaseLable!=null){
                        databaseLable.setIsSelected("1");
                        lableDao.update(databaseLable);
                    }else{
                        lableDao.insert(lable);
                    }
                }
            }
        });
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
