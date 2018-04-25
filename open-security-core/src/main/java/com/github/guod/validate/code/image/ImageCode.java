package com.github.guod.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:19:46
 * @JDK 1.8
 * @Description 功能模块：
 */
public class ImageCode extends ValidateCode {
    private BufferedImage image;

    /**
     * 功能：设置验证码
     *
     * @param image
     * @param code
     * @param expireTime
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    /**
     * 功能：验证码过期的时间点
     *
     * @param image
     * @param code
     * @param expireIn
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
