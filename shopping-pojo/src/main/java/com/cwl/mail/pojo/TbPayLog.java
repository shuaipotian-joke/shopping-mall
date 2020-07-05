package com.cwl.mail.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbPayLog implements Serializable {
    /**
     * 支付订单号
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 支付完成时间
     *
     * @mbg.generated
     */
    private Date payTime;

    /**
     * 支付金额（分）
     *
     * @mbg.generated
     */
    private Long totalFee;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * 交易号码
     *
     * @mbg.generated
     */
    private String transactionId;

    /**
     * 交易状态
     *
     * @mbg.generated
     */
    private String tradeState;

    /**
     * 订单编号列表
     *
     * @mbg.generated
     */
    private String orderList;

    /**
     * 支付类型
     *
     * @mbg.generated
     */
    private String payType;

    private static final long serialVersionUID = 1L;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", userId=").append(userId);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", tradeState=").append(tradeState);
        sb.append(", orderList=").append(orderList);
        sb.append(", payType=").append(payType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}