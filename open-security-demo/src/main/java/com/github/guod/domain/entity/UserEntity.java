/**
 *
 */
package com.github.guod.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonView;


/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月19日 时间:下午6:34:20
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@Entity
@Table(name = "tb_user")
public class UserEntity extends BaseEntity {
	/**
	 * 简单视图
	 */
	public interface UserSimpleView {
	}

	/**
	 * 详细视图
	 */
	public interface UserDetailView extends UserSimpleView {
	}

	@JsonView(UserSimpleView.class)
	private String name;
	@JsonView(UserDetailView.class)
	private Integer age;

	@JsonView(UserSimpleView.class)
	private String school;

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
