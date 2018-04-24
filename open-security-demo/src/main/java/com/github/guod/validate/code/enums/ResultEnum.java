/**
 *
 */
package com.github.guod.validate.code.enums;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:上午10:59:22
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
public enum ResultEnum {
	UNKNOW_ERROR(-200, "异常信息"),
	RETURN_SUCCESS(200, "成功"), 
	RETURN_ERROE(200, "成功")
	
	
	
	
	;
	private Integer code;
	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
