package com.cwl.mail.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbOrderItem implements Serializable {
    private Long id;

    /**
     * 商品id
     *
     * @mbg.generated
     */
    private Long itemId;

    /**
     * SPU_ID
     *
     * @mbg.generated
     */
    private Long goodsId;

    /**
     * 订单id
     *
     * @mbg.generated
     */
    private Long orderId;

    /**
     * 商品标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 商品单价
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     * 商品购买数量
     *
     * @mbg.generated
     */
    private Integer num;

    /**
     * 商品总金额
     *
     * @mbg.generated
     */
    private BigDecimal totalFee;

    /**
     * 商品图片地址
     *
     * @mbg.generated
     */
    private String picPath;

    private String sellerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", orderId=").append(orderId);
        sb.append(", title=").append(title);
        sb.append(", price=").append(price);
        sb.append(", num=").append(num);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", picPath=").append(picPath);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}