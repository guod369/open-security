/**
 *
 */
package com.github.guod.domain.vo;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月19日 时间:下午6:36:07
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
public class UserVO {
	private String id;

	private String name;

	private Integer age;

	private String school;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
