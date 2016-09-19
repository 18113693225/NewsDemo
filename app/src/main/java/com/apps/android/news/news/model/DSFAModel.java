package com.apps.android.news.news.model;

import com.apps.android.news.news.db.greendao.entity.*;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DSFAModel implements Serializable {
    private List<com.apps.android.news.news.db.greendao.entity.Lable> channels;//获取所有频道
    private List<News> news;//获取用户频道所对应的新闻
    private String state;//发送验证码回执
    private String valiCodeState;//验证验证码回执
    private Customer user;//用户注册成功！返回数据
    public DSFAModel() {
    }

    /**
     * 获取所有频道
     * @return
     */
    public List<Lable> getLables() {
        return channels;
    }

    public void setChannels(List<Lable> channels) {
        this.channels = channels;
    }

    /**
     * 获取用户频道新闻
     * @return
     */
    public List<News> getUserLableNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    /**
     * 短信是否发送成功
     * @return
     */
    public boolean getState() {
        return "1".equals(this.state);
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 验证码是否正确
     * @return
     */
    public boolean getValiCodeState() {
        return "1".equals(valiCodeState);
    }

    public void setValiCodeState(String valiCodeState) {
        this.valiCodeState = valiCodeState;
    }

    /**
     * 获取注册用户
     * @return
     */
    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }
}
