package com.xxdy.springboot.listenner;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @Title:
 * @Author: longlh
 * @Description:
 * @Copyright: Copyright (c) 2019
 * @Company: deyou.com
 * @Date: 2020/3/21 2:20
 */
@Component("rabbitMQReceiveListener")
public class RabbitMQReceiveListener {

    @RabbitListener(queues = "myQueues")
    public void receive(Message message) {
        try {
            String body = new String(message.getBody(),"utf-8");
            System.out.println("接收到的消息为：" + body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
