package com.github.guod.authentication;

import com.alibaba.fastjson.JSON;
import com.github.guod.SecurityProperties;
import com.github.guod.validate.code.enums.LoginType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
 * @date 日期:2018/4/24 时间:7:55
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component(value = "meAuthenticationSuccessHandler")
public class MeAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final static Logger logger = LoggerFactory.getLogger(MeAuthenticationSuccessHandler.class);
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("[{}]", "登录成功！");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
