package com.apps.android.news.news.db.greendao.entity;

/**
 * Created by Administrator on 2016/9/17.
 */
public class Image {
    private String id;//图片ID
    private String aId;//新闻ID
    private String imgUrl;//大图地址
    private String sUrl;//缩略图地址

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public Image(String id, String aId, String imgUrl, String sUrl) {
        this.id = id;
        this.aId = aId;
        this.imgUrl = imgUrl;
        this.sUrl = sUrl;
    }
}
