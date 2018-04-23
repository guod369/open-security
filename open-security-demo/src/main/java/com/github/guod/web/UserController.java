/**
 *
 */
package com.github.guod.web;

import com.github.guod.domain.entity.UserEntity;
import com.github.guod.domain.vo.Result;
import com.github.guod.service.UserServiceI;
import com.github.guod.util.ResultUtils;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:57:03
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserServiceI userServiceI;

	@GetMapping(value = "/getCurrentUser")
	public Object getCurrentUser(){
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@GetMapping(value = "/getMe")
	public Object getMe(Authentication authentication){
		return authentication;
	}

	@GetMapping(value = "/getUser")
	public Object getUser(@AuthenticationPrincipal UserDetails user){
		return user;
	}

	@GetMapping(value = "/query")
	@JsonView(UserEntity.UserSimpleView.class)
	public Result<UserEntity> query() {
		return ResultUtils.seccess(userServiceI.doUserList());
	}

	@GetMapping(value = "/getUserInfot/{id}")
	@JsonView(UserEntity.UserDetailView.class)
	public Result<UserEntity> getUserInfot(@PathVariable(name = "id") String id) {
		return ResultUtils.seccess(userServiceI.getuserInfo(id));

	}

}
