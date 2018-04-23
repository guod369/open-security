package com.github.guod;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:18:52
 * @JDK 1.8
 * @Description 功能模块：
 */
@ConfigurationProperties(prefix = "guod.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
