package com.apps.android.news.news.db.greendao.dao;

import android.content.Context;

import com.apps.android.news.news.db.DBManager;
import com.apps.android.news.news.db.greendao.entity.Customer;
import com.apps.android.news.news.db.greendao.gen.CustomerDao;

import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
public class CustomerManager {

    private static CustomerManager mInstance;
    private static CustomerDao customerDao;
    private Context context;
    private CustomerManager(Context context){
        this.context = context;
        customerDao = DBManager.getInstance(context).getDaoSession().getCustomerDao();
    }

    public static CustomerManager getInstance(Context context){
        if (mInstance == null) {
            synchronized (LableManager.class) {
                if (mInstance == null) {
                    mInstance = new CustomerManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 保存用户
     * @param customer
     * @return
     */
    public boolean saveCustomer(Customer customer){
        Customer other = customerDao.queryBuilder().unique();
        long i = customerDao.insert(customer);
        if(i>0&&other!=null){
            customerDao.deleteByKey(other.get_id());
        }
        return i>0;
    }

    /**
     * 获取用户信息
     * @return
     */
    public Customer getCustomer(){
        return customerDao.queryBuilder().unique();
    }
}
