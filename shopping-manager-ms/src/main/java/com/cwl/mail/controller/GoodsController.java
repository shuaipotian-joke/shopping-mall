package com.cwl.mail.controller;

import com.alibaba.fastjson.JSON;
import com.cwl.mail.activemq.JmsConfig;
import com.cwl.mail.entity.RespBean;
import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.pojo.Goods;
import com.cwl.mail.pojo.TbGoods;
import com.cwl.mail.pojo.TbItem;
import com.cwl.mail.pojo.TbItemCat;
import com.cwl.mail.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    GoodsService goodsService;
    @RequestMapping("/findOneEntity")
    public Goods findOneEntity(Long id){
        return goodsService.findOneEntity(id);
    }
    @RequestMapping("/updateEntity")
    public RespBean updateEntity(@RequestBody Goods goods){
        // 获得商家信息:
        //String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
//        String sellerId = "yqtech"; //暂时设定
//        Goods goods2 = goodsService.findOneEntity(goods.getGoods().getId());
//        if(!sellerId.equals(goods2.getGoods().getSellerId()) || !sellerId.equals(goods.getGoods().getSellerId())){
//            return RespBean.error( "非法操作");
//        }

        try {
            goodsService.updateEntity(goods);
            return RespBean.ok( "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error( "修改失败");
        }
    }
    @RequestMapping("/addEntity")
    public RespBean addEntity(@RequestBody Goods goods){
        System.out.println("#######"+goods.getGoods().getGoodsName()+"#######");
        System.out.println("#######"+goods.getGoodsDesc().getItemImages());
        System.out.println("#######"+goods.getGoodsDesc().getSpecificationItems());
        System.out.println("#######"+goods.getGoodsDesc().getCustomAttributeItems());

        try {
            // 获得商家信息:
            //String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
            String sellerId = "yqtech"; //暂时设定
            goods.getGoods().setSellerId(sellerId);

            goodsService.addEntity(goods);
            return RespBean.ok( "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("增加失败");
        }
    }

    @GetMapping("/findAllGoods")
    public List<TbGoods> findAllGoods(){
        return goodsService.findAllGoods();
    }

    @PostMapping("/search")
    public ResultPage search(int pageNum,int pageSize,@RequestBody TbGoods goods){
//        goods.setSellerId("yqtech");


        return goodsService.findByPage(pageNum,pageSize,goods);
    }

    @GetMapping("/deleteGoods")
    public RespBean deleteGoods(Long[] ids){
        try{
            goodsService.delete(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            return RespBean.error("删除失败");
        }
    }

    @RequestMapping("/updateStatus")
    public RespBean updateStatus(Long[] ids,String status){
        try{
            goodsService.updateStatus(ids);
            List<TbItem> itemList = goodsService.findItemListByGoodsIdListAndStatus(ids, "1");

            final String jsonString = JSON.toJSONString(itemList);
            System.out.println(jsonString);
            Topic topicSolrDestination = new ActiveMQTopic(JmsConfig.TOPIC_SOLR);
            jmsTemplate.send(topicSolrDestination, new MessageCreator() {

                @Override
                public Message createMessage(Session session) throws JMSException {

                    return session.createTextMessage(jsonString);
                }
            });
            //****3. 生成商品详细页 freemarker
            for(final Long goodsId:ids){
                Topic topicPageDestination = new ActiveMQTopic(JmsConfig.TOPIC_HTML);
                jmsTemplate.send(topicPageDestination, new MessageCreator() {

                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(goodsId+"");
                    }
                });
            }
            return RespBean.ok("测试成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("测试成功");
    }
}
