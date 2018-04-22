/**
 *
 */
package com.github.guod.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:下午1:10:52
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Entity
@Table(name = "tb_body")
public class BodyEntity extends BaseEntity {
	private String name;
	private Integer age;

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

}
