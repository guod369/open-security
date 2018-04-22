/**
 *
 */
package com.github.guod.service;

import java.util.List;

import com.github.guod.domain.entity.UserEntity;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:49:06
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
public interface UserServiceI {

	List<UserEntity> doUserList();

	UserEntity getuserInfo(String id);

}
