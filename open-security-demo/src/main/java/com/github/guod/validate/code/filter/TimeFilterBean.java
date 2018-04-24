/**
 * 
 */
package com.github.guod.validate.code.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * project -
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:下午4:08:27
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：
 */
public class TimeFilterBean implements Filter {

	@Override
	public void destroy() {
		System.out.println("TimeFilterBean filter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("TimeFilterBean filter start");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println(new Date().getTime() - start);
		System.out.println("TimeFilterBean filter finish");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("TimeFilterBean filter init");
	}

}
