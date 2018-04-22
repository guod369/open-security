/**
 *
 */
package com.github.guod.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project - 权限管理系统
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午8:03:34
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
	private String name;
	private Integer age;
	private String cupSize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

}
