package com.apps.android.news.news.model;

import com.apps.android.news.news.db.greendao.entity.Image;
import com.apps.android.news.news.db.greendao.entity.Lable;
import com.apps.android.news.news.db.greendao.entity.News;
import com.apps.android.news.news.utils.util.JsonUtils;
import com.apps.android.news.news.utils.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DSFANews implements Serializable{
    private String news;
    private String images;
    private String labels;

    private News content;

    public DSFANews() {
    }

    public News getContent() {
        return content;
    }

    public void setContent(News content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}
