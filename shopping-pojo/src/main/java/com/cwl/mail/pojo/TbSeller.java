package com.cwl.mail.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbSeller implements Serializable {
    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private String sellerId;

    /**
     * 公司名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 店铺名称
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * EMAIL
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 公司手机
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 公司电话
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 详细地址
     *
     * @mbg.generated
     */
    private String addressDetail;

    /**
     * 联系人姓名
     *
     * @mbg.generated
     */
    private String linkmanName;

    /**
     * 联系人QQ
     *
     * @mbg.generated
     */
    private String linkmanQq;

    /**
     * 联系人电话
     *
     * @mbg.generated
     */
    private String linkmanMobile;

    /**
     * 联系人EMAIL
     *
     * @mbg.generated
     */
    private String linkmanEmail;

    /**
     * 营业执照号
     *
     * @mbg.generated
     */
    private String licenseNumber;

    /**
     * 税务登记证号
     *
     * @mbg.generated
     */
    private String taxNumber;

    /**
     * 组织机构代码
     *
     * @mbg.generated
     */
    private String orgNumber;

    /**
     * 公司地址
     *
     * @mbg.generated
     */
    private Long address;

    /**
     * 公司LOGO图
     *
     * @mbg.generated
     */
    private String logoPic;

    /**
     * 简介
     *
     * @mbg.generated
     */
    private String brief;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 法定代表人
     *
     * @mbg.generated
     */
    private String legalPerson;

    /**
     * 法定代表人身份证
     *
     * @mbg.generated
     */
    private String legalPersonCardId;

    /**
     * 开户行账号名称
     *
     * @mbg.generated
     */
    private String bankUser;

    /**
     * 开户行
     *
     * @mbg.generated
     */
    private String bankName;

    private static final long serialVersionUID = 1L;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanQq() {
        return linkmanQq;
    }

    public void setLinkmanQq(String linkmanQq) {
        this.linkmanQq = linkmanQq;
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    public String getLinkmanEmail() {
        return linkmanEmail;
    }

    public void setLinkmanEmail(String linkmanEmail) {
        this.linkmanEmail = linkmanEmail;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public String getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPersonCardId() {
        return legalPersonCardId;
    }

    public void setLegalPersonCardId(String legalPersonCardId) {
        this.legalPersonCardId = legalPersonCardId;
    }

    public String getBankUser() {
        return bankUser;
    }

    public void setBankUser(String bankUser) {
        this.bankUser = bankUser;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sellerId=").append(sellerId);
        sb.append(", name=").append(name);
        sb.append(", nickName=").append(nickName);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", telephone=").append(telephone);
        sb.append(", status=").append(status);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", linkmanName=").append(linkmanName);
        sb.append(", linkmanQq=").append(linkmanQq);
        sb.append(", linkmanMobile=").append(linkmanMobile);
        sb.append(", linkmanEmail=").append(linkmanEmail);
        sb.append(", licenseNumber=").append(licenseNumber);
        sb.append(", taxNumber=").append(taxNumber);
        sb.append(", orgNumber=").append(orgNumber);
        sb.append(", address=").append(address);
        sb.append(", logoPic=").append(logoPic);
        sb.append(", brief=").append(brief);
        sb.append(", createTime=").append(createTime);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", legalPersonCardId=").append(legalPersonCardId);
        sb.append(", bankUser=").append(bankUser);
        sb.append(", bankName=").append(bankName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}