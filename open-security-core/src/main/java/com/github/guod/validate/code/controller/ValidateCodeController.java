package com.github.guod.validate.code.controller;

import com.github.guod.validate.code.image.ImageCode;
import com.github.guod.validate.code.image.ValidateCode;
import com.github.guod.validate.code.service.SmsCodeSender;
import com.github.guod.validate.code.service.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:19:50
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class ValidateCodeController {
    public final static String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    /**
     * 功能：图形验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/code/image")
    private void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generator(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    @GetMapping(value = "/code/sms")
    private void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ValidateCode smsCode = smsCodeGenerator.generator(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);
        /**
         * 请求中必须包含一个mobile
         */
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        smsCodeSender.send(mobile, smsCode.getCode());

    }

}
