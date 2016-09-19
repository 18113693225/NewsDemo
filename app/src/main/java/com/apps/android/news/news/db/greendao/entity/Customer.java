package com.apps.android.news.news.db.greendao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/19.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable {
    @Id
    private Long _id;
    private String id;
    private String stochastic;
    private String account;
    private String pawsserd;
    private String head;
    private String phone;
    private String email;
    private String creat_date;
    private String effective;
    private String customer_name;
    private String type;
    private String info;
    private String trade;
    private String province;
    private String city;
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return this.province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getTrade() {
        return this.trade;
    }
    public void setTrade(String trade) {
        this.trade = trade;
    }
    public String getInfo() {
        return this.info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCustomer_name() {
        return this.customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getEffective() {
        return this.effective;
    }
    public void setEffective(String effective) {
        this.effective = effective;
    }
    public String getCreat_date() {
        return this.creat_date;
    }
    public void setCreat_date(String creat_date) {
        this.creat_date = creat_date;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getHead() {
        return this.head;
    }
    public void setHead(String head) {
        this.head = head;
    }
    public String getPawsserd() {
        return this.pawsserd;
    }
    public void setPawsserd(String pawsserd) {
        this.pawsserd = pawsserd;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getStochastic() {
        return this.stochastic;
    }
    public void setStochastic(String stochastic) {
        this.stochastic = stochastic;
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
    @Generated(hash = 451733943)
    public Customer(Long _id, String id, String stochastic, String account,
            String pawsserd, String head, String phone, String email,
            String creat_date, String effective, String customer_name, String type,
            String info, String trade, String province, String city) {
        this._id = _id;
        this.id = id;
        this.stochastic = stochastic;
        this.account = account;
        this.pawsserd = pawsserd;
        this.head = head;
        this.phone = phone;
        this.email = email;
        this.creat_date = creat_date;
        this.effective = effective;
        this.customer_name = customer_name;
        this.type = type;
        this.info = info;
        this.trade = trade;
        this.province = province;
        this.city = city;
    }
    @Generated(hash = 60841032)
    public Customer() {
    }

}
