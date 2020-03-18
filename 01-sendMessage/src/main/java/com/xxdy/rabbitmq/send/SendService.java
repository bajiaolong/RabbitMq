package com.xxdy.rabbitmq.send;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Title:
 * @Author: longlh
 * @Description:
 * @Copyright: Copyright (c) 2019
 * @Company: deyou.com
 * @Date: 2020/3/17 16:47
 */
public class SendService {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("ip");  //设置主机ip
        //设置端口
        factory.setPort(5672);
        //设置用户名
        //todo 需要修改用户名和密码
        factory.setUsername("用户名");
        //设置密码
        factory.setPassword("密码");

        //创建链接
        Connection connection = factory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //创建消息
        String message = "这是消息内容";

        //参数1 我们自定义的交换机名称
        //参数2 自定义的RoutingKey值
        //参数3 设置消息的属性，可以通过消息属性设置消息是否是持久化的
        //参数4 具体要发送的消息信息

        //定义消息属性对象 设置deliveryMode(1) 表示消息不需要持久化  deliveryMode(2)需要持久化
        //在性能持久化消息要低于非持久化消息，在安全上持久化消息在服务器宕机之后还可以保留因此安全性相对要高一些
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().deliveryMode(2).build();

        //发布消息
        channel.basicPublish("model1", "myRoutingKey", properties, message.getBytes("utf-8") );

        System.out.println("消息成功发送");
        //关闭通道/链接
        channel.close();
        connection.close();

    }
}
