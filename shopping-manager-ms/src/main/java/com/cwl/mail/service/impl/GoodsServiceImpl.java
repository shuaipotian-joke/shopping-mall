package com.cwl.mail.service.impl;

import com.alibaba.fastjson.JSON;
import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.mapper.*;
import com.cwl.mail.pojo.*;
import com.cwl.mail.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    TbGoodsMapper tbGoodsMapper ;
    @Autowired
    TbGoodsDescMapper tbGoodsDescMapper;
    @Autowired
    TbItemMapper itemMapper;
    @Autowired
    TbItemCatMapper tbItemCatMapper;
    @Autowired
    TbBrandMapper brandMapper;
    @Autowired
    TbSellerMapper sellerMapper;
    @Override
    public Goods findOneEntity(Long id) {
        Goods goods = new Goods();
        TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(id);
        TbGoodsDesc tbGoodsDesc = tbGoodsDescMapper.selectByPrimaryKey(id);
        goods.setGoods(tbGoods);
        goods.setGoodsDesc(tbGoodsDesc);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        List<TbItem> list = itemMapper.selectByExample(example);
        goods.setItemList(list);
        return goods;
    }

    @Override
    public void addEntity(Goods goods) {
        goods.getGoods().setAuditStatus("0"); // 设置审核的状态

        tbGoodsMapper.insert(goods.getGoods()); // 插入商品信息   tb_goods   spu（回填主键id到pojo对象中）

        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());  //设置tb_goods_desc表的外键和主键

        tbGoodsDescMapper.insert(goods.getGoodsDesc()); // 插入商品的扩展信息

        setItemList(goods);//保存sku信息
    }

    @Override
    public List<TbGoods> findAllGoods() {
        return tbGoodsMapper.selectByExample(null);
    }

    @Override
    public ResultPage findByPage(int pageNum, int pageSize, TbGoods goods) {
        PageHelper.startPage(pageNum, pageSize);
        TbGoodsExample example = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = example.createCriteria();
        if(goods!=null){
            if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
                System.out.println("设置sellerId: " + goods.getSellerId());
                criteria.andSellerIdEqualTo(goods.getSellerId());
            }
            if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
                criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
            }
            if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
                criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
            }
            if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
                criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
            }
            if(goods.getCaption()!=null && goods.getCaption().length()>0){
                criteria.andCaptionLike("%"+goods.getCaption()+"%");
            }
            if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
                criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
            }
            if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
                criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
            }
            if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
                criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
            }
        }
        Page page = (Page)tbGoodsMapper.selectByExample(example);
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        return resultPage;
    }

    /**
     * 修改
     */
    @Override
    public void updateEntity(Goods goods){
        // 修改商品信息
        goods.getGoods().setAuditStatus("0");
        tbGoodsMapper.updateByPrimaryKey(goods.getGoods());
        // 修改商品扩展信息:
        tbGoodsDescMapper.updateByPrimaryKey(goods.getGoodsDesc());
        // 修改SKU信息:
        // 先删除，再保存:
        // 删除SKU的信息:
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getGoods().getId());
        itemMapper.deleteByExample(example);
        // 保存SKU的信息
        setItemList(goods);
    }

    private void setItemList(Goods goods){
        System.out.println("是否启用规格：" + goods.getGoods().getIsEnableSpec());
        if("1".equals(goods.getGoods().getIsEnableSpec())){
            // 启用规格
            // 保存SKU列表的信息:
            for(TbItem item:goods.getItemList()){
                // 设置SKU的数据：
                // item.setTitle(title);
                String title = goods.getGoods().getGoodsName();
                Map<String,String> map = JSON.parseObject(item.getSpec(), Map.class);
                for (String key : map.keySet()) {
                    title+= " "+map.get(key);
                }
                item.setTitle(title);

                setValue(goods,item);

                itemMapper.insert(item);
            }
        }else{
            // 没有启用规格
            TbItem item = new TbItem();

            item.setTitle(goods.getGoods().getGoodsName());

            item.setPrice(goods.getGoods().getPrice());

            item.setNum(999);

            item.setStatus("0");

            item.setIsDefault("1");
            item.setSpec("{}");

            setValue(goods,item);
            itemMapper.insert(item);
        }
    }

    private void setValue(Goods goods,TbItem item){

        List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(),Map.class);

        if(imageList.size()>0){
            item.setImage((String)imageList.get(0).get("url"));
        }

        // 保存三级分类的ID:
        item.setCategoryid(goods.getGoods().getCategory3Id());
        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());
        // 设置商品ID
        item.setGoodsId(goods.getGoods().getId());
        item.setSellerId(goods.getGoods().getSellerId());
        TbItemCat itemCat = tbItemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());

        item.setCategory(itemCat.getName());

        TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());

        item.setBrand(brand.getName());

        TbSeller seller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());

        item.setSeller(seller.getNickName());
    }
    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
//			goodsMapper.deleteByPrimaryKey(id);
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(id);
            tbGoods.setIsDelete("1");
            tbGoodsMapper.updateByPrimaryKey(tbGoods);
        }
    }

    @Override
    public void updateStatus(Long[] ids) {
        for(Long id:ids) {
            tbGoodsMapper.updateStatusByPrimaryKey(id);
        }
    }

    @Override
    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status) {
        System.out.println("Goods Id列表：" + goodsIds);
        System.out.println("状态：" + status);
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);//状态
        criteria.andGoodsIdIn(Arrays.asList(goodsIds));//指定条件：SPUID集合

        return itemMapper.selectByExample(example);
    }
}
