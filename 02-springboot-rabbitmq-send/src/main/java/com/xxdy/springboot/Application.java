package com.xxdy.springboot;

import com.xxdy.springboot.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Title:
 * @Author: longlh
 * @Description:
 * @Copyright: Copyright (c) 2019
 * @Company: deyou.com
 * @Date: 2020/3/21 1:54
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        SendService sendService = (SendService) applicationContext.getBean("sendService");
        sendService.send();
    }
}
