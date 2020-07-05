package com.cwl.mail.service;

import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.pojo.Goods;
import com.cwl.mail.pojo.TbGoods;
import com.cwl.mail.pojo.TbItem;

import java.util.List;

public interface GoodsService {
    public Goods findOneEntity(Long id);

    void addEntity(Goods goods);

    List<TbGoods> findAllGoods();

    ResultPage findByPage(int pageNum, int pageSize, TbGoods goods);

    void updateEntity(Goods goods);

    void delete(Long[] ids);

    void updateStatus(Long[] ids);

    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status);
}
