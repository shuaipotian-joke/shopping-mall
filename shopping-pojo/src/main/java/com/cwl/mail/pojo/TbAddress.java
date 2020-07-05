package com.cwl.mail.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbAddress implements Serializable {
    private Long id;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * 省
     *
     * @mbg.generated
     */
    private String provinceId;

    /**
     * 市
     *
     * @mbg.generated
     */
    private String cityId;

    /**
     * 县/区
     *
     * @mbg.generated
     */
    private String townId;

    /**
     * 手机
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 详细地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 联系人
     *
     * @mbg.generated
     */
    private String contact;

    /**
     * 是否是默认 1默认 0否
     *
     * @mbg.generated
     */
    private String isDefault;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String notes;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     * 别名
     *
     * @mbg.generated
     */
    private String alias;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", townId=").append(townId);
        sb.append(", mobile=").append(mobile);
        sb.append(", address=").append(address);
        sb.append(", contact=").append(contact);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", notes=").append(notes);
        sb.append(", createDate=").append(createDate);
        sb.append(", alias=").append(alias);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}