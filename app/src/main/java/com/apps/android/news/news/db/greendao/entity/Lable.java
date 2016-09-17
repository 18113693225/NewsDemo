package com.apps.android.news.news.db.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@Entity
public class Lable {
    @Id
    private Long _id;
    private String id;
    private String name;
    private String orderId;
    private String isSelected;

    @Transient
    public int index;

    @Generated(hash = 524917412)
    public Lable(Long _id, String id, String name, String orderId, String isSelected) {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.isSelected = isSelected;
    }

    @Generated(hash = 719657878)
    public Lable() {
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }

    public String getIsSelected() {
        return this.isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }


    /**
     * 测试数据
     */
    public static Iterable<Lable> getTestData() {
        List<Lable> lables = new ArrayList<Lable>();
        lables.add(new Lable(null, "1", "推荐", "1", "1"));
        lables.add(new Lable(null, "2", "热点", "2", "1"));
        lables.add(new Lable(null, "3", "上海", "3", "1"));
        lables.add(new Lable(null, "4", "社会", "4", "1"));
        lables.add(new Lable(null, "5", "产业链", "5", "1"));
        lables.add(new Lable(null, "6", "娱乐", "6", "1"));
        lables.add(new Lable(null, "7", "科技", "7", "1"));
        lables.add(new Lable(null, "8", "汽车", "8", "1"));
        lables.add(new Lable(null, "9", "农业", "9", "1"));
        lables.add(new Lable(null, "10", "非农", "10", "0"));
        lables.add(new Lable(null, "11", "体育", "11", "0"));
        lables.add(new Lable(null, "12", "财经", "12", "0"));
        lables.add(new Lable(null, "13", "房产", "13", "0"));
        lables.add(new Lable(null, "14", "特卖", "14", "0"));
        lables.add(new Lable(null, "15", "商机", "15", "0"));
        return lables;
    }


}
