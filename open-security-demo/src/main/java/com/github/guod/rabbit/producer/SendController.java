package com.github.guod.rabbit.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:9:56
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@RequestMapping("/test")
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/testSend")
    public String testSend() {
        // 使用AmqpTemplate发送消息
        System.out.println("调用生产者向guo消息队列中存入信息");
        amqpTemplate.convertAndSend("guo", "guo消息队列中存入信息");
        return "success";
    }
}
