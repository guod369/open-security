/**
 *
 */
package com.github.guod.util;

import com.github.guod.domain.vo.Result;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:上午9:37:59
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
public class ResultUtils {
	/**
	 * @Title seccess
	 * @param object
	 * @date 日期:2018年4月21日 时间:上午9:39:10
	 * @return Result<T>
	 * @Description 功能：成功
	 */
	@SuppressWarnings("unchecked")
	public static <T> Result<T> seccess(Object object) {
		Result<T> result = new Result<>();
		result.setCode(200);
		result.setMsg("操作成");
		result.setData((T) object);
		return result;
	}

	public static <T> Result<T> seccess() {
		return seccess(null);
	}

	public static <T> Result<T> error(Integer code, String msg) {
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

}
