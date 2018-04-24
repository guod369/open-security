package com.github.guod.code;

import com.github.guod.validate.code.image.ImageCode;
import com.github.guod.validate.code.service.ValidateCodeGenerator;

import javax.servlet.http.HttpServletRequest;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:19:09
 * @JDK 1.8
 * @Description 功能模块：此处可以覆盖原来的图形验证码代码
 */
//@Component(value = "imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generator(HttpServletRequest request) {
        System.out.println("写更高级的代码，实现图形验证码");
        return null;
    }
}
