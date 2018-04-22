/**
 *
 */
package com.github.guod.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月19日 时间:下午6:35:35
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Entity
@Table(name = "tb_girl")
public class GirlEntity extends BaseEntity{
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
