package com.github.guod.web;

import com.github.guod.async.AsyncConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/22 时间:11:46
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class TackController {
    @Autowired
    private AsyncConfiguration asyncConfiguration;

    @GetMapping(value = "/test")
    public String test() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncConfiguration.doTaskOne();
        Future<Boolean> b = asyncConfiguration.doTaskTwo();
        Future<Boolean> c = asyncConfiguration.doTaskThree();
        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String time = "任务的全部执行完毕，总耗时间：" + (end - start) + "毫秒";
        System.out.println(time);
        return time;
    }
}
