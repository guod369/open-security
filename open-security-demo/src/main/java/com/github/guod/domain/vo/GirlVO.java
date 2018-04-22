/**
 *
 */
package com.github.guod.domain.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月19日 时间:下午6:35:49
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
public class GirlVO {
	/**
	 * 简单视图
	 */
	public interface GirlSimpleValidate {
	}

	/**
	 * 详细视图
	 */
	public interface GirlDetailValidate extends GirlSimpleValidate {
	}

	@ApiModelProperty(value = "用户ID", hidden = false)
	private String id;
	@NotNull(groups = GirlDetailValidate.class)
	@ApiModelProperty(value = "姓名", hidden = false)
	private String name;
	@NotNull
	@ApiModelProperty(value = "年龄", hidden = false)
	private Integer age;
	@ApiModelProperty(value = "大小", hidden = false)
	private String cupSize;

	public Integer getAge() {
		return age;
	}

	public String getCupSize() {
		return cupSize;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
