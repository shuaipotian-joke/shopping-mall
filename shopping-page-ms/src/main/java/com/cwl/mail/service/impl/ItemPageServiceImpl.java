package com.cwl.mail.service.impl;

import com.cwl.mail.mapper.TbGoodsDescMapper;
import com.cwl.mail.mapper.TbGoodsMapper;
import com.cwl.mail.mapper.TbItemCatMapper;
import com.cwl.mail.mapper.TbItemMapper;
import com.cwl.mail.pojo.TbGoods;
import com.cwl.mail.pojo.TbGoodsDesc;
import com.cwl.mail.pojo.TbItem;
import com.cwl.mail.pojo.TbItemExample;
import com.cwl.mail.service.ItemPageService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ItemPageServiceImpl implements ItemPageService {
    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;

    String pagedir = "d:\\item\\";
    @Autowired
    TbGoodsMapper goodsMapper;
    @Autowired
    TbGoodsDescMapper goodsDescMapper;
    @Autowired
    TbItemMapper itemMapper;
    @Autowired
    TbItemCatMapper itemCatMapper;
    @Override
    public boolean genItemHTML(Long goodsId) {
        Configuration configuration = freeMarkerConfigurer.getConfiguration();

        try {
            Template template = configuration.getTemplate("item.ftl");
            //创建数据模型
            Map dataModel=new HashMap<>();
            //1.商品主表数据
            TbGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goods", goods);
            //2.商品扩展表数据
            TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goodsDesc", goodsDesc);
            //3.读取商品分类

            String itemCat1 = itemCatMapper.selectByPrimaryKey(goods.getCategory1Id()).getName();
            String itemCat2 = itemCatMapper.selectByPrimaryKey(goods.getCategory2Id()).getName();
            String itemCat3 = itemCatMapper.selectByPrimaryKey(goods.getCategory3Id()).getName();
            dataModel.put("itemCat1", itemCat1);
            dataModel.put("itemCat2", itemCat2);
            dataModel.put("itemCat3", itemCat3);

            //4.读取SKU列表
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId);//SPU ID
            criteria.andStatusEqualTo("1");//状态有效
            example.setOrderByClause("is_default desc");//按是否默认字段进行降序排序，目的是返回的结果第一条为默认SKU

            List<TbItem> itemList = itemMapper.selectByExample(example);

            dataModel.put("itemList", itemList);

            Writer out=new FileWriter(pagedir+goodsId+".html");

            template.process(dataModel, out);//输出
            out.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteItemHTML(Long[] goodsIds) {
        return false;
    }
}
