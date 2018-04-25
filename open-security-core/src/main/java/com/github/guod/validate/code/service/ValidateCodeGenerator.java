package com.github.guod.validate.code.service;

import com.github.guod.validate.code.image.ValidateCode;

import javax.servlet.http.HttpServletRequest;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:18:56
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface ValidateCodeGenerator {
    ValidateCode generator(HttpServletRequest request);
}
