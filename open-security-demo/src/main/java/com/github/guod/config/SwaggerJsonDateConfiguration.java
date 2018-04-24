package com.github.guod.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:17:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class SwaggerJsonDateConfiguration extends FastJsonHttpMessageConverter{
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
        super.writeInternal(object, outputMessage);
    }
}
