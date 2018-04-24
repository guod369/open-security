package com.github.guod.validate.code.controller;

import com.github.guod.properties.SecurityProperties;
import com.github.guod.vo.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:18:16
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class BrowserSecurityController {
    private final static Logger logger = LoggerFactory.getLogger(BrowserSecurityController.class);
    private RequestCache requestCache = new HttpSessionRequestCache();
    /**
     * spring工具类：页面跳转
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 功能：需要身份认证，跳到此controller
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/requestAuthentication")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requestAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是：[{}]", targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，引导用户到登录页！");
    }
}
