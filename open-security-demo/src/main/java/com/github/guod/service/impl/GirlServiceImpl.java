/**
 *
 */
package com.github.guod.service.impl;

import com.github.guod.dao.GirlDaoI;
import com.github.guod.domain.entity.GirlEntity;
import com.github.guod.exception.DemoException;
import com.github.guod.service.GirlServiceI;
import com.github.guod.validate.code.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月21日 时间:上午9:50:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
@CacheConfig(cacheNames = "user")
public class GirlServiceImpl implements GirlServiceI {
    @Autowired
    private GirlDaoI girlDaoI;

    @Override
    @Cacheable(key = "getAge")
    public void getAge(String id) throws Exception {
        GirlEntity findOne = girlDaoI.findOne(id);
        Integer age = findOne.getAge();
        if (age < 10) {
            // 返回message和code
            throw new DemoException(ResultEnum.RETURN_SUCCESS);
        } else if (age > 10 && age < 16) {
            throw new DemoException(ResultEnum.RETURN_SUCCESS);
        }

    }

    @Override
    @Cacheable
    public List<GirlEntity> findAllGirl() {
        return girlDaoI.findAll();
    }


}
