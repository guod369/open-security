/**
 *
 */
package com.github.guod.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.guod.properties.GirlProperties;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:57:50
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：rest full风格接口入门
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloWordController {
	@Autowired
	private GirlProperties girlProperties;
	@Autowired
	private ApplicationContext ctx;
	@Value("${girl.name}")
	private String name;

	/**
	 * @Title index
	 * @date 日期:2018年4月20日 时间:上午8:14:20
	 * @return String
	 * @Description 功能：第一个hello world
	 */
	@GetMapping(value = "/index")
	public String index() {
		return "Hello World!";
	}

	/**
	 * @Title home
	 * @date 日期:2018年4月20日 时间:上午8:16:26
	 * @return String
	 * @Description 功能：获取配置文件中的属性值
	 */
	@GetMapping(value = "/home")
	public String home() {
		return girlProperties.getName() + girlProperties.getAge() + girlProperties.getCupSize() + ctx.getEnvironment().getProperty("girl.name") + name;
	}

	/**
	 * @Title say  
	 * @param myId
	 * @date 日期:2018年4月20日 时间:上午8:38:23
	 * @return String
	 * @Description 功能：请求的参数
	 */
	@GetMapping(value = "/say")
	public String say(@RequestParam(value = "id", defaultValue = "0", required = false) Integer myId) {
		return "ID：" + myId;
	}
}
