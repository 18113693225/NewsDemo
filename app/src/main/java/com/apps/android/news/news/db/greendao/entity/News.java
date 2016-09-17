package com.apps.android.news.news.db.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/16.
 */
@Entity
public class News {
   @Id
   private Long _id;
   private String id;
   private String userId;
   private String status;
   private String title;
   private String remark;
   private String displayMode;
   private String isTop;
   private String url;
   private String createTime;
   private String modifyTime;
   private String price;
   private String auditUserId;
   private String auditDate;
   public String getAuditDate() {
      return this.auditDate;
   }
   public void setAuditDate(String auditDate) {
      this.auditDate = auditDate;
   }
   public String getAuditUserId() {
      return this.auditUserId;
   }
   public void setAuditUserId(String auditUserId) {
      this.auditUserId = auditUserId;
   }
   public String getPrice() {
      return this.price;
   }
   public void setPrice(String price) {
      this.price = price;
   }
   public String getModifyTime() {
      return this.modifyTime;
   }
   public void setModifyTime(String modifyTime) {
      this.modifyTime = modifyTime;
   }
   public String getCreateTime() {
      return this.createTime;
   }
   public void setCreateTime(String createTime) {
      this.createTime = createTime;
   }
   public String getUrl() {
      return this.url;
   }
   public void setUrl(String url) {
      this.url = url;
   }
   public String getIsTop() {
      return this.isTop;
   }
   public void setIsTop(String isTop) {
      this.isTop = isTop;
   }
   public String getDisplayMode() {
      return this.displayMode;
   }
   public void setDisplayMode(String displayMode) {
      this.displayMode = displayMode;
   }
   public String getRemark() {
      return this.remark;
   }
   public void setRemark(String remark) {
      this.remark = remark;
   }
   public String getTitle() {
      return this.title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getStatus() {
      return this.status;
   }
   public void setStatus(String status) {
      this.status = status;
   }
   public String getUserId() {
      return this.userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
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
   @Generated(hash = 201289369)
   public News(Long _id, String id, String userId, String status, String title,
         String remark, String displayMode, String isTop, String url,
         String createTime, String modifyTime, String price, String auditUserId,
         String auditDate) {
      this._id = _id;
      this.id = id;
      this.userId = userId;
      this.status = status;
      this.title = title;
      this.remark = remark;
      this.displayMode = displayMode;
      this.isTop = isTop;
      this.url = url;
      this.createTime = createTime;
      this.modifyTime = modifyTime;
      this.price = price;
      this.auditUserId = auditUserId;
      this.auditDate = auditDate;
   }
   @Generated(hash = 1579685679)
   public News() {
   }

}
