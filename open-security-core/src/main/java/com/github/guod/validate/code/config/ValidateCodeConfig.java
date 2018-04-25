package com.github.guod.validate.code.config;

import com.github.guod.properties.SecurityProperties;
import com.github.guod.validate.code.service.SmsCodeSender;
import com.github.guod.validate.code.service.ValidateCodeGenerator;
import com.github.guod.validate.code.service.impl.SmsCodeSenderImpl;
import com.github.guod.validate.code.service.impl.ImageCodeGeneratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:19:03
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class ValidateCodeConfig {
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGeneratorImpl validateCodeGenerator = new ImageCodeGeneratorImpl();
        validateCodeGenerator.setSecurityProperties(securityProperties);
        return validateCodeGenerator;
    }


    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new SmsCodeSenderImpl();
    }

}
