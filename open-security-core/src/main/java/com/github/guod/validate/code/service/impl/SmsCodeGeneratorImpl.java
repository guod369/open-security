package com.github.guod.validate.code.service.impl;

import com.github.guod.properties.SecurityProperties;
import com.github.guod.validate.code.image.ValidateCode;
import com.github.guod.validate.code.service.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:18:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component("smsCodeGenerator")
public class SmsCodeGeneratorImpl implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public ValidateCode generator(HttpServletRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }


}
