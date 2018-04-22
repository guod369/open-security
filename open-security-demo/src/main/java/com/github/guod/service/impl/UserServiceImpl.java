/**
 *
 */
package com.github.guod.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.guod.domain.entity.UserEntity;
import com.github.guod.repository.BaseRepository;
import com.github.guod.service.UserServiceI;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:49:53
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private BaseRepository<UserEntity> userRepository;

	@Override
	public List<UserEntity> doUserList() {
		List<UserEntity> userList = userRepository.find(" from UserEntity u ");
		return userList;
	}

	@Override
	public UserEntity getuserInfo(String id) {
		UserEntity userEntity = userRepository.get(" from UserEntity u where u.id = ?", id);
		return userEntity;
	}

}
