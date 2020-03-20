package com.xxdy.springboot.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Author: longlh
 * @Description:
 * @Copyright: Copyright (c) 2019
 * @Company: deyou.com
 * @Date: 2020/3/21 2:06
 */
@Component("sendService")
public class SendService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String message = "我们都是好孩子3";
        //转换并发送消息
        //参数1 我们自定义的交换机名称  就是Exchange名
        //参数2 我们自定义的路由key的名 就是RoutingKey 名字
        //参数3 就是我们需要发送具体的消息数据
        amqpTemplate.convertAndSend("model1", "myRoutingKey",message);
        System.out.println("消息发送成功");
    }
}
