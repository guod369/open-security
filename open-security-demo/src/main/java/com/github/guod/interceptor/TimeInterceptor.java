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
 * @version 3.0
 * @date 日期:2018年4月21日 时间:下午4:44:36
 * @JDK:version used:jdk1.8
 * @Description 功能模块：
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 功能：在请求处理之前调用（controller方法之前）
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("TimeInterceptor interceptor preHandle");
        System.out.println(((HandlerMethod) o).getBean().getClass().getName());
        System.out.println(((HandlerMethod) o).getMethod().getName());
        request.setAttribute("startTime", new Date().getTime());
        return true;
    }

    /**
     * 功能：请求处理之后调用，但是在视图渲染之前（controller方法之后）
     *
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor interceptor postHandle");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println(new Date().getTime() - start);
    }

    /**
     * 功能：整个请求结束后被调用，也就是dispatcherservlet渲染了对应的视图后执行（主要用于资源清理工作）
     *
     * @param request
     * @param response
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("TimeInterceptor interceptor afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println(new Date().getTime() - start);
    }

}
