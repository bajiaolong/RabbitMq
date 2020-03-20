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
 * @Date: 2020/3/21 2:02
 */
@Component("recieveService")
public class RecieveService {
    @Autowired
    private AmqpTemplate  amqpTemplate;

    public void recieve(){

        //参数1 我们自定义的消息队列名称
        String str = (String) amqpTemplate.receiveAndConvert("myQueues");
        System.out.println("接收到的消息为："+str);
    }
}
