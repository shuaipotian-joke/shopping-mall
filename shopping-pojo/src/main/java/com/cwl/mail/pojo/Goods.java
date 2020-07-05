package com.cwl.mail.pojo;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {

    private TbGoods goods; // 商品信息   spu   tb_goods
    private TbGoodsDesc goodsDesc; // 商品扩展信息  tb_goods_desc

    private List<TbItem> itemList; // SKU的列表信息   tb_item

    public TbGoods getGoods() {
        return goods;
    }
    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }
    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }
    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    public List<TbItem> getItemList() {
        return itemList;
    }
    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }
}