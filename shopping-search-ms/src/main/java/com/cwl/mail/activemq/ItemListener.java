package com.cwl.mail.activemq;

import com.alibaba.fastjson.JSON;
import com.cwl.mail.pojo.TbItem;
import com.cwl.mail.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.List;

@Component
public class ItemListener {
    @Autowired
    ItemSearchService itemSearchService;

    @JmsListener(destination = JmsConfig.TOPIC_SOLR,containerFactory = "jmsListenerContainerTopic")
    public void onItemSearch(Message message){
        TextMessage textMessage = (TextMessage)message;
        try {
            String text = textMessage.getText();
            System.out.println("监听到消息："+text);
            List<TbItem> itemList = JSON.parseArray(text, TbItem.class);
            itemSearchService.importList(itemList);
            System.out.println("导入solr索引库");
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
