package com.cwl.mail.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbSeckillOrder implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 秒杀商品ID
     *
     * @mbg.generated
     */
    private Long seckillId;

    /**
     * 支付金额
     *
     * @mbg.generated
     */
    private BigDecimal money;

    /**
     * 用户
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * 商家
     *
     * @mbg.generated
     */
    private String sellerId;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 支付时间
     *
     * @mbg.generated
     */
    private Date payTime;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 收货人地址
     *
     * @mbg.generated
     */
    private String receiverAddress;

    /**
     * 收货人电话
     *
     * @mbg.generated
     */
    private String receiverMobile;

    /**
     * 收货人
     *
     * @mbg.generated
     */
    private String receiver;

    /**
     * 交易流水
     *
     * @mbg.generated
     */
    private String transactionId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", seckillId=").append(seckillId);
        sb.append(", money=").append(money);
        sb.append(", userId=").append(userId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", status=").append(status);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", receiver=").append(receiver);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}