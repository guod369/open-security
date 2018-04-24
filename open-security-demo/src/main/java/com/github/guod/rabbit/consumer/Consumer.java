package com.github.guod.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:9:54
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class Consumer {
    /**
     * 定义一个消费者
     *
     * @param message
     */
    @RabbitListener(queues = "guo")
    public void handler(String message) {
        System.out.println("消费者从中接收消息：" + message);
    }
}
