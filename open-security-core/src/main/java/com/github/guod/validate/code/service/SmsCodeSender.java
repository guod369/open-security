package com.github.guod.validate.code.service;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/25 时间:12:52
 * @JDK 1.8
 * @Description 功能模块：短信发送
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
