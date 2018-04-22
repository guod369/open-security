/**
 *
 */
package com.github.guod.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.guod.domain.vo.Result;
import com.github.guod.exception.DemoException;
import com.github.guod.util.ResultUtils;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年4月21日 时间:上午10:01:06
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {
	public final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public <T> Result<T> handle(Exception e) {
		if (e instanceof DemoException) {
			DemoException demoException = (DemoException) e;
			return ResultUtils.error(demoException.getCode(), demoException.getMessage());
		} else {
			logger.info("系统错误信息[{}]", e);
			return ResultUtils.error(-1, "未知错误");
		}
	}
}
