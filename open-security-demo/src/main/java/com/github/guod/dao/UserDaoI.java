/**
 *
 */
package com.github.guod.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.guod.domain.entity.UserEntity;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:47:24
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
public interface UserDaoI extends JpaRepository<UserEntity, Serializable> {

}
