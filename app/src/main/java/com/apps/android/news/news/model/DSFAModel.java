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
    private List<com.apps.android.news.news.db.greendao.entity.Lable> channels;
    private List<News> news;

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
}
