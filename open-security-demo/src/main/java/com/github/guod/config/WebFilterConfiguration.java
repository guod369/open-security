/**
 *
 */
package com.github.guod.config;

import com.github.guod.validate.code.filter.TimeFilterBean;
import com.github.guod.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月21日 时间:下午4:17:27
 * @JDK:version used:jdk1.8
 * @Description 功能模块：
 */
@Configuration
public class WebFilterConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private TimeInterceptor interceptor;

    /**
     * 顺序：根据注册的顺序进行执行
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/hello/**");
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
