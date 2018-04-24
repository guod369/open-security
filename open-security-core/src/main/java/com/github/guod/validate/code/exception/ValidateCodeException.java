package com.github.guod.validate.code.exception;

import org.springframework.security.core.AuthenticationException;


/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/3/18 时间:9:43
 * @JDK 1.8
 * @Description 功能模块：
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
