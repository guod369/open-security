/**
 * 
 */
package com.github.guod.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.guod.filter.TimeFilterBean;
import com.github.guod.interceptor.TimeInterceptor;

/**
 * project -
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:下午4:17:27
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Configuration
public class WebFilterConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	private TimeInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		TimeFilterBean timeFilterBean = new TimeFilterBean();
		registrationBean.setFilter(timeFilterBean);
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		return registrationBean;
	}

}
