/**
 *
 */
package com.github.guod.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * project - ETC发票系统
 *
 * @author guod 
 * @date 日期:2018年4月21日 时间:上午11:49:07
 * @JDK 1.8 
 * @version 3.0
 * @Description 功能模块： 
 */
@Component
public class CorsConfiguration extends WebMvcConfigurerAdapter{
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry
	                .addMapping("/**")
	                .allowedMethods("*")
	                .allowedOrigins("*")
	                .allowedHeaders("*");
	    }
}
