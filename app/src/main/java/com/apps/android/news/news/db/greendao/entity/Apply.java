package com.apps.android.news.news.db.greendao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/9/19.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Apply {
    @Id
    private Long _id;
    private String id;//	id
    private String customer_id;//	用户id
    private String company_name;//	公司名称
    private String license;//	营业执照路径
    private String apply_date;//	申请时间
    private String freason;//	审核失败理由
    private String effective;//	是否通过 0未审核 1 审核通过 2 审核不通过
    private String list_id;//	名录id
    private String address;//	公司地址
    private String legal_person;//	法人
    private String reg_capital;//	注册资金
    private String company_type;//	企业类型
    private String scope;//	经营范围
    private String reg_num;//	注册号
    private String province;//	省份
    private String city;//	城市
    private String industry;//	行业
    public String getIndustry() {
        return this.industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
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
    public String getReg_num() {
        return this.reg_num;
    }
    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }
    public String getScope() {
        return this.scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    public String getCompany_type() {
        return this.company_type;
    }
    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }
    public String getReg_capital() {
        return this.reg_capital;
    }
    public void setReg_capital(String reg_capital) {
        this.reg_capital = reg_capital;
    }
    public String getLegal_person() {
        return this.legal_person;
    }
    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getList_id() {
        return this.list_id;
    }
    public void setList_id(String list_id) {
        this.list_id = list_id;
    }
    public String getEffective() {
        return this.effective;
    }
    public void setEffective(String effective) {
        this.effective = effective;
    }
    public String getFreason() {
        return this.freason;
    }
    public void setFreason(String freason) {
        this.freason = freason;
    }
    public String getApply_date() {
        return this.apply_date;
    }
    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }
    public String getLicense() {
        return this.license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public String getCompany_name() {
        return this.company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getCustomer_id() {
        return this.customer_id;
    }
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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
    @Generated(hash = 1188026581)
    public Apply(Long _id, String id, String customer_id, String company_name,
            String license, String apply_date, String freason, String effective,
            String list_id, String address, String legal_person,
            String reg_capital, String company_type, String scope, String reg_num,
            String province, String city, String industry) {
        this._id = _id;
        this.id = id;
        this.customer_id = customer_id;
        this.company_name = company_name;
        this.license = license;
        this.apply_date = apply_date;
        this.freason = freason;
        this.effective = effective;
        this.list_id = list_id;
        this.address = address;
        this.legal_person = legal_person;
        this.reg_capital = reg_capital;
        this.company_type = company_type;
        this.scope = scope;
        this.reg_num = reg_num;
        this.province = province;
        this.city = city;
        this.industry = industry;
    }
    @Generated(hash = 1176249019)
    public Apply() {
    }

}
