package com.cwl.mail.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    private Long id;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 密码，加密存储
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 注册手机号
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 注册邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date created;

    private Date updated;

    /**
     * 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     *
     * @mbg.generated
     */
    private String sourceType;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * 真实姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 使用状态（Y正常 N非正常）
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 头像地址
     *
     * @mbg.generated
     */
    private String headPic;

    /**
     * QQ号码
     *
     * @mbg.generated
     */
    private String qq;

    /**
     * 账户余额
     *
     * @mbg.generated
     */
    private Long accountBalance;

    /**
     * 手机是否验证 （0否  1是）
     *
     * @mbg.generated
     */
    private String isMobileCheck;

    /**
     * 邮箱是否检测（0否  1是）
     *
     * @mbg.generated
     */
    private String isEmailCheck;

    /**
     * 性别，1男，2女
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * 会员等级
     *
     * @mbg.generated
     */
    private Integer userLevel;

    /**
     * 积分
     *
     * @mbg.generated
     */
    private Integer points;

    /**
     * 经验值
     *
     * @mbg.generated
     */
    private Integer experienceValue;

    /**
     * 生日
     *
     * @mbg.generated
     */
    private Date birthday;

    /**
     * 最后登录时间
     *
     * @mbg.generated
     */
    private Date lastLoginTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck;
    }

    public String getIsEmailCheck() {
        return isEmailCheck;
    }

    public void setIsEmailCheck(String isEmailCheck) {
        this.isEmailCheck = isEmailCheck;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", nickName=").append(nickName);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", headPic=").append(headPic);
        sb.append(", qq=").append(qq);
        sb.append(", accountBalance=").append(accountBalance);
        sb.append(", isMobileCheck=").append(isMobileCheck);
        sb.append(", isEmailCheck=").append(isEmailCheck);
        sb.append(", sex=").append(sex);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", points=").append(points);
        sb.append(", experienceValue=").append(experienceValue);
        sb.append(", birthday=").append(birthday);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}