package com.github.guod.properties;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/24 时间:18:21
 * @JDK 1.8
 * @Description 功能模块：
 */
public class ImageCodeProperties extends SmsCodeProperties {
    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 63;
    private int height = 23;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
