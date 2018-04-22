/**
 * 
 */
package com.github.guod.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:下午4:08:27
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Component
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("TimeFilter filter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("TimeFilter filter start");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println(new Date().getTime() - start);
		System.out.println("TimeFilter filter finish");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("TimeFilter filter init");
	}

}
