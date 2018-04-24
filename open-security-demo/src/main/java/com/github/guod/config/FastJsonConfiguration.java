/**
 *
 */
package com.github.guod.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:上午11:40:30
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Component
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {
	/**
	 * 修改自定义消息转换器
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 调用父类的配置
		super.configureMessageConverters(converters);
		// 创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 将fastjson添加到视图消息转换器列表内
		converters.add(fastConverter);
	}
}
