package com.xxdy.recive;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Title:
 * @Author: longlh
 * @Description:
 * @Copyright: Copyright (c) 2019
 * @Company: deyou.com
 * @Date: 2020/3/18 15:26
 */
public class ReciveService {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("ip");
        factory.setPort(5672);
        factory.setUsername("用户名");
        factory.setPassword("密码");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //创建消费者对象
        Consumer consumer =new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "utf-8");
                System.out.println("接收到的消息为："+message);
            }
        };
        //将消费者对象设置到指定通道中，并监听某个队列，如果队列有新的消息则直接调用consumer对象中的handleDelivery方法获取消息
        //参数1 消息队列的名称
        //参数2 接收消息以后是否将消息从队列中移除 建议使用true 当消息处理完成后会自动的清空被处理过的消息，
        // 可以实现解决消息被重复消费的问题
        //参数3 设定由哪个消费监听消息
        channel.basicConsume("myQueues",true, consumer);
    }
}
