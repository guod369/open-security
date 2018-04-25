package com.github.guod.validate.code.service.impl;

import com.github.guod.validate.code.service.SmsCodeSender;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/25 时间:12:53
 * @JDK 1.8
 * @Description 功能模块：
 */
public class SmsCodeSenderImpl implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机：" + mobile + "发送的验证：" + code);
    }
}
