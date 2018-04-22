/**
 *
 */
package com.github.guod.exception;

import com.github.guod.enums.ResultEnum;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:上午10:05:53
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：异常返回处理，RuntimeException异常会事物回滚
 */
public class DemoException extends RuntimeException {
	private static final long serialVersionUID = -4129209826051341164L;
	/**
	 * 错误码
	 */
	private Integer code;

	public DemoException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
