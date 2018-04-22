package com.github.guod.tack;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/22 时间:11:30
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class TackConfiguration {
    @Scheduled(fixedRate = 3000)
    public void sysoutTack(){
        System.out.println("开始定时任务"+ LocalDateTime.now());
    }
}
