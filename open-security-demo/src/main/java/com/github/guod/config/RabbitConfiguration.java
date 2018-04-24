package com.github.guod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:9:48
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue queue() {
        return new Queue("guo");
    }
}
