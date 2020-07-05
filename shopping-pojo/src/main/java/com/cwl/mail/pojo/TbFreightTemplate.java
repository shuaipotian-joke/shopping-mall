package com.cwl.mail.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbFreightTemplate implements Serializable {
    private Long id;

    /**
     * 商家ID
     *
     * @mbg.generated
     */
    private String sellerId;

    /**
     * 是否默认   （‘Y’是   'N'否）
     *
     * @mbg.generated
     */
    private String isDefault;

    /**
     * 模版名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）
     *
     * @mbg.generated
     */
    private String sendTimeType;

    /**
     * 统一价格
     *
     * @mbg.generated
     */
    private Long price;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSendTimeType() {
        return sendTimeType;
    }

    public void setSendTimeType(String sendTimeType) {
        this.sendTimeType = sendTimeType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", name=").append(name);
        sb.append(", sendTimeType=").append(sendTimeType);
        sb.append(", price=").append(price);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}