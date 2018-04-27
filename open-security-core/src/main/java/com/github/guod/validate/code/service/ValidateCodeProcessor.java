package com.github.guod.validate.code.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/26 时间:8:10
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface ValidateCodeProcessor {
    /**
     * 功能：创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
