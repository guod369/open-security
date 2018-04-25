package com.github.guod.validate.code.image;

import java.time.LocalDateTime;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:19:46
 * @JDK 1.8
 * @Description 功能模块：短信验证码
 */
public class ValidateCode {
    private String code;

    private LocalDateTime expireTime;

    /**
     * 功能：设置验证码
     *
     * @param code
     * @param expireTime
     */
    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 功能：验证码过期的时间点
     *
     * @param code
     * @param expireIn
     */
    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
