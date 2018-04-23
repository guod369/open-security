package com.github.guod.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:20:05
 * @JDK 1.8
 * @Description 功能模块：只被调用一次
 */
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals("/requestAuthentication", request.getRequestURI()) && StringUtils.equals(request.getMethod(), "post")) {
            try {
                validate(new ServletWebRequest(request));
            } catch (Exception e) {
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private void validate(ServletWebRequest servletWebRequest) {
    }
}
