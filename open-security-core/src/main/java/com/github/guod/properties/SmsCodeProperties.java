package com.github.guod.properties;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:18:21
 * @JDK 1.8
 * @Description 功能模块：
 */
public class SmsCodeProperties {
    private int length = 4;
    private int expireIn = 60;

    private String urls;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
