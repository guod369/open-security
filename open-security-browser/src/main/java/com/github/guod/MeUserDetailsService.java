package com.github.guod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/23 时间:13:30
 * @JDK 1.8
 * @Description 功能模块：自定义用户认证逻辑
 */
@Component
public class MeUserDetailsService implements UserDetailsService {
    private final static Logger logger = LoggerFactory.getLogger(MeUserDetailsService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 每次加密后的结果是不一样的，混入的有盐
         */
        String password = passwordEncoder.encode("123456");
        logger.info("登录用户名：[{}],用户登录密码[{}]", username, password);
        /**
         * return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"))
         */
        return new User("guod", password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
