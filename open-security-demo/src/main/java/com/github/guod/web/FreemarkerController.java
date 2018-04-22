package com.github.guod.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/22 时间:12:42
 * @JDK 1.8
 * @Description 功能模块：
 */
@Controller
@RequestMapping(value = "ftl")
public class FreemarkerController {
    @GetMapping(value = "/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "guo");
        return "freemarker/index";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "freemarker/home/home";
    }
}
