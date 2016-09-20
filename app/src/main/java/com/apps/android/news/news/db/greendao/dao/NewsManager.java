package com.apps.android.news.news.db.greendao.dao;

import android.content.Context;

import com.apps.android.news.news.db.DBManager;
import com.apps.android.news.news.db.greendao.entity.Image;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.db.greendao.entity.News;
import com.apps.android.news.news.db.greendao.gen.LableDao;
import com.apps.android.news.news.db.greendao.gen.NewsDao;
import com.apps.android.news.news.utils.util.StringUtils;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public class NewsManager {

    private static int PAGE_SIZE = 15;//新闻显示条数
    private static NewsManager mInstance;
    private static NewsDao newsDao;
    private Context context;
    private NewsManager(Context context){
        this.context = context;
        newsDao = DBManager.getInstance(context).getDaoSession().getNewsDao();
    }

    public static NewsManager getInstance(Context context){
        if (mInstance == null) {
            synchronized (NewsManager.class) {
                if (mInstance == null) {
                    mInstance = new NewsManager(context);
                }
            }
        }
        return mInstance;
    }


    /**
     * 拉取发布时间之前的数据，
     * 不填则默认拉取最新数据
     * @param lableId 频道ID
     * @param auditDate  发布时间
     * @return
     */
    public List<News> getNewsByLable(String lableId,String auditDate){
        QueryBuilder qb =null;
        if(StringUtils.isNotBlank(auditDate)) {
            qb = newsDao.queryBuilder().where(NewsDao.Properties.LableId.eq(lableId),NewsDao.Properties.AuditDate.lt(auditDate));
        }else{
           qb = newsDao.queryBuilder().where(NewsDao.Properties.LableId.eq(lableId));
        }
        List<News> newsList = qb.orderDesc(NewsDao.Properties.AuditDate).limit(PAGE_SIZE).list();
        return newsList;
    }

    /**
     * 保存新闻数据
     * @param news
     */
    public void saveNews(List<News> news){
        newsDao.insertInTx(news);
    }


    /**
     * 初始化测试数据
     */
    public void initTestData(){
       long count = newsDao.count();
        if(count==0){
            newsDao.insertInTx(News.getTestData());
        }
    }

}
