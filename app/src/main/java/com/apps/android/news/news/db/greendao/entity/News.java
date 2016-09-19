package com.apps.android.news.news.db.greendao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class News {
   @Id
   private Long _id;//主键
   private String id;//新闻ID
   private String lableId;//频道Id
   private String userId;//发布人ID
   private String status;//文章状态(0草稿箱，1待检索，-1回退，3发布)
   private String title;//标题
   private String remark;//摘要
   private String displayMode;//0、纯文字 1、大图文  2、小图文 3、多图
   private String isTop;//是否置顶 0、否 1、是
   private String url;//静态页面地址
   private String createTime;//创建时间
   private String modifyTime;//修改时间
   private String priceType;//价格模式 -3：非供需信息  -2:面议 -1：议价 0：其他
   private String price;//当priceType=0时 必填；供需页面的 所标价格
   private String auditUserId;//审核人ID
   private String auditDate;//审核时间
   private String images;//图片数组字符串
   private String labels;//标签数组字符串

   @Transient
   private List<Image> imageList;
   @Transient
   private List<Lable> lableList;

@Generated(hash = 1780465411)
public News(Long _id, String id, String lableId, String userId, String status, String title, String remark, String displayMode, String isTop, String url, String createTime, String modifyTime,
                String priceType, String price, String auditUserId, String auditDate, String images, String labels) {
        this._id = _id;
        this.id = id;
        this.lableId = lableId;
        this.userId = userId;
        this.status = status;
        this.title = title;
        this.remark = remark;
        this.displayMode = displayMode;
        this.isTop = isTop;
        this.url = url;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.priceType = priceType;
        this.price = price;
        this.auditUserId = auditUserId;
        this.auditDate = auditDate;
        this.images = images;
        this.labels = labels;
}

@Generated(hash = 1579685679)
public News() {
}

   public List<Lable> getLableList() {
      this.lableList = new ArrayList<Lable>();
      try {
         JSONArray lableArray = new JSONArray(this.labels);
         JSONObject lableObj = null;
         Lable lable = null;
         int size = lableArray.length();
         for(int i=0;i<size;i++){
            lableObj = lableArray.getJSONObject(i);
            lable = new Lable(null,lableObj.getString("id"),lableObj.getString("name"),i+"","0");
            lableList.add(lable);
         }
      } catch (JSONException e) {
         e.printStackTrace();
      }
      return this.lableList;
   }

   public List<Image> getImageList() {
      this.imageList = new ArrayList<Image>();
      try {
         JSONArray imageArray = new JSONArray(this.images);
         JSONObject imageObj = null;
         Image image = null;
         int size = imageArray.length();
         for(int i=0;i<size;i++){
            imageObj = imageArray.getJSONObject(i);
            image = new Image(imageObj.getString("id"),imageObj.getString("aId"),imageObj.getString("imgUrl"),imageObj.getString("sUrl"));
            imageList.add(image);
         }
      } catch (JSONException e) {
         e.printStackTrace();
      }
      return this.imageList;
   }
    public News(String id,String auditDate,String displayMode,String title,String remark,String url,String images,String lables,String isTop){
        this.id = id;
        this.auditDate = auditDate;
        this.displayMode = displayMode;
        this.title = title;
        this.remark = remark;
        this.url = url;
        this.images = images;
        this.labels = lables;
        this.isTop = isTop;
        this.lableId = "1";
    }

    public News(String lableId,String id,String auditDate,String displayMode,String title,String remark,String url,String images,String lables,String isTop){
        this.id = id;
        this.auditDate = auditDate;
        this.displayMode = displayMode;
        this.title = title;
        this.remark = remark;
        this.url = url;
        this.images = images;
        this.labels = lables;
        this.isTop = isTop;
        this.lableId = lableId;
    }


   public static Iterable<News> getTestData(){
      List<News> list = new ArrayList<News>();
      list.add(new News("newsId_0","2016-08-10 12:11:11","0","我的新闻标题","我的新闻摘要","http://www.baidu.com",
              "[" +
                  "{id:'imageId_0',aId:'newsId_0',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                  "{id:'imageId_1',aId:'newsId_0',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                  "{id:'imageId_2',aId:'newsId_0',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
              "]",
              "[{id:'lableId_0',name:'展会'}," +
               "{id:'lableId_1',name:'上海'}," +
               "{id:'lableId_2',name:'科技'}," +
               "{id:'lableId_3',name:'产业链'}]",
              "0"));
      list.add(new News("newsId_1","2016-08-10 10:11:11","1","习大大领航九天揽月新征途","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_1',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_1',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_1',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_4',name:'征途'}," +
               "{id:'lableId_5',name:'飞天'}]",
              "0"));
      list.add(new News("newsId_2","2016-08-10 09:11:11","2","俄罗斯工人和朝鲜工人在俄一斌工厂群殴","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_2',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_2',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_2',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_6',name:'打架'}," +
                      "{id:'lableId_7',name:'群殴'}]",
              "1"));
      list.add(new News("newsId_4","2016-08-09 12:11:11","3","1老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_4',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_4',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_4',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_5","2016-08-09 10:11:11","3","2老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_5',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_5',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_5',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_6","2016-08-09 02:11:11","3","3老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_6',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_6',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_6',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_7","2016-08-08 22:11:11","3","4老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_7',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_7',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_7',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_8","2016-08-08 20:11:11","3","5老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_8',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_8',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_8',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_9","2016-08-08 12:11:11","3","6老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_9',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_9',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_9',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_10","2016-08-08 09:11:11","3","7老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_10',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_10',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_10',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_11","2016-08-08 08:11:11","3","8老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_11',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_11',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_11',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_12","2016-08-08 07:11:11","3","9老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_12',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_12',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_12',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_13","2016-08-08 06:11:11","3","10老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_13',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_13',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_13',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_14","2016-08-08 05:11:11","3","11老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_14',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_14',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_14',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_15","2016-08-08 04:11:11","3","12老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_15',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_15',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_15',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_16","2016-08-08 03:11:11","3","13老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_16',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_16',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_16',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_17","2016-08-08 02:11:11","3","14老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_17',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_17',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_17',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_18","2016-08-08 01:11:11","3","15老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_18',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_18',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_18',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_19","2016-08-07 22:11:11","3","16老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_19',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_19',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_19',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_20","2016-08-07 20:11:11","3","17老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_20',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_20',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_20',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_21","2016-08-07 12:11:11","3","18老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_21',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_21',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_21',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_22","2016-08-07 11:11:11","3","19老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_22',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_22',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_22',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_23","2016-08-07 10:11:11","3","20老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_23',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_23',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_23',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_24","2016-08-07 09:11:11","3","21老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_24',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_24',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_24',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("newsId_25","2016-08-07 09:11:11","3","22老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_25',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));

      list.add(new News("2","newsId_25","2016-09-07 09:11:11","3","22老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_25',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("2","newsId_26","2016-09-06 04:11:11","3","23老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_25',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("2","newsId_27","2016-09-06 05:11:11","3","2老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_25',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
      list.add(new News("2","newsId_28","2016-09-04 09:11:11","3","22老外考汉语听力遇到《江南皮革厂倒闭了》表情简直萌爆了","我的新闻摘要","http://www.baidu.com",
              "[" +
                      "{id:'imageId_0',aId:'newsId_25',imgUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg',sUrl:'http://sc.jb51.net/uploads/allimg/150421/14-1504211A6210-L.jpg'}," +
                      "{id:'imageId_1',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg',sUrl:'http://scimg.jb51.net/allimg/150921/14-1509211509580-L.jpg'}," +
                      "{id:'imageId_2',aId:'newsId_25',imgUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg',sUrl:'http://scimg.jb51.net/allimg/160101/14-1601011126390-L.jpg'}" +
                      "]",
              "[{id:'lableId_8',name:'老外'}]",
              "0"));
       return list;
   }

public String getLabels() {
        return this.labels;
}

public void setLabels(String labels) {
        this.labels = labels;
}

public String getImages() {
        return this.images;
}

public void setImages(String images) {
        this.images = images;
}

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

public String getPriceType() {
        return this.priceType;
}

public void setPriceType(String priceType) {
        this.priceType = priceType;
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

public String getLableId() {
        return this.lableId;
}

public void setLableId(String lableId) {
        this.lableId = lableId;
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



}
