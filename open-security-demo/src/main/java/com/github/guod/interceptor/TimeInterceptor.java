/**
 * 
 */
package com.github.guod.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * project -
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:下午4:44:36
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		System.out.println("TimeInterceptor interceptor preHandle");
		System.out.println(((HandlerMethod) o).getBean().getClass().getName());
		System.out.println(((HandlerMethod) o).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
		System.out.println("TimeInterceptor interceptor postHandle");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println(new Date().getTime() - start);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
		System.out.println("TimeInterceptor interceptor afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println(new Date().getTime() - start);
	}

}
