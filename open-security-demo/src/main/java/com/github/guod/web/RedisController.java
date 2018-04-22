package com.github.guod.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.guod.domain.entity.GirlEntity;
import com.github.guod.domain.vo.Result;
import com.github.guod.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/22 时间:11:05
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/setValueString")
    public Result<String> setValueString() {
        stringRedisTemplate.opsForValue().set("guoString", "郭东升 hello world redis");
        return ResultUtils.seccess(stringRedisTemplate.opsForValue().get("guod"));
    }


    @GetMapping(value = "/setValueObject")
    public Result<String> setValueObject() {
        GirlEntity girlEntity = new GirlEntity();
        girlEntity.setName("guo");
        girlEntity.setAge(22);
        stringRedisTemplate.opsForValue().set("guoJson", JSON.toJSONString(girlEntity));
        JSONObject jsonObject = JSON.parseObject(stringRedisTemplate.opsForValue().get("guod"));
        return ResultUtils.seccess(jsonObject);
    }
}
