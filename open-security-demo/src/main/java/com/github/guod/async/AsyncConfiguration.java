package com.github.guod.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/22 时间:11:39
 * @JDK 1.8
 * @Description 功能模块：异步定时任务，使用场景发送短信、发送邮件、App消息推送、节省运维凌晨发布任务的效率（消息队列：kafka、MQ）
 */
@Component
public class AsyncConfiguration {
    @Async
    public Future<Boolean> doTaskOne() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTaskTwo() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTaskThree() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        return new AsyncResult<>(true);
    }
}
