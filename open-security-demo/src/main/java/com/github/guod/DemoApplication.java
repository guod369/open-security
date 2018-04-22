/**
 *
 */
package com.github.guod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年3月2日 时间:下午12:57:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DemoApplication {

    /**
     * @param args
     * @return void
     * @Title main
     * @date 日期:2018年3月2日 时间:下午12:57:23
     * @Description 功能：程序入口
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
