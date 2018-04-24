package com.github.guod.authentication;

import com.alibaba.fastjson.JSON;
import com.github.guod.properties.SecurityProperties;
import com.github.guod.validate.code.enums.LoginType;
import com.github.guod.vo.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:8:08
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component(value = "meAuthenticationFailHandler")
public class MeAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    private final static Logger logger = LoggerFactory.getLogger(MeAuthenticationFailHandler.class);

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("[{}]", "登录失败！");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(new SimpleResponse(exception.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }


    }
}
