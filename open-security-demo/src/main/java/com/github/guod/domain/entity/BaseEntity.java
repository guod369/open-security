/**
 *
 */
package com.github.guod.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:21:59
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 32)
	private String id;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime=LocalDateTime.now();
	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;
	/**
	 * 是否删除 1、删除 0 、正常
	 */
	@Type(type = "true_false")
	private Boolean isDeleate=false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getIsDeleate() {
		return isDeleate;
	}

	public void setIsDeleate(Boolean isDeleate) {
		this.isDeleate = isDeleate;
	}

}
