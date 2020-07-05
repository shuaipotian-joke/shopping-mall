package com.cwl.mail.activemq;

import com.cwl.mail.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class PageListener {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    ItemPageService itemPageService;
    @JmsListener(destination = JmsConfig.TOPIC_HTML,containerFactory = "jmsListenerContainerTopic")
    public void OnPageCreate(Message message){
        TextMessage textMessage = (TextMessage)message;
        try{
            System.out.println("接收到消息："+textMessage.getText());
            boolean b = itemPageService.genItemHTML(Long.parseLong(textMessage.getText()));
            System.out.println("网页生成结果："+b);
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
