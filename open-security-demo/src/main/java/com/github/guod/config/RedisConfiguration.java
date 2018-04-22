package com.github.guod.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/22 时间:11:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class RedisConfiguration {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 功能：实现命令，TTL key，以秒为单位，返回给定key的剩余生存时间（time to live）
     *
     * @param key
     * @return
     */
    public long timeToLive(String key) {
        return redisTemplate.getExpire(key);
    }

}
