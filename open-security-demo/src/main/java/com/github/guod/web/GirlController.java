/**
 *
 */
package com.github.guod.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.guod.dao.GirlDaoI;
import com.github.guod.domain.entity.GirlEntity;
import com.github.guod.domain.vo.GirlVO;
import com.github.guod.domain.vo.Result;
import com.github.guod.service.GirlServiceI;
import com.github.guod.util.ResultUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @date 日期:2018年4月20日 时间:上午7:57:20
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@RestController
@RequestMapping(value = "/girl")
@Api(value = "用户操作接口", tags = { "用户操作接口" })
public class GirlController {
	@Autowired
	private GirlDaoI girlDaoI;
	@Autowired
	private GirlServiceI girlServiceI;

	@PostMapping(value = "/doGirlSave")
	@ApiOperation(value = "保存用户Girl", notes = "保存用户Girl")
	public Result<GirlEntity> doSave(@RequestBody @ApiParam(name = "用户对象", value = "传入Json格式", required = true) @Valid GirlVO vo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		GirlEntity girlEntity = new GirlEntity();
		girlEntity.setName(vo.getName());
		girlEntity.setAge(vo.getAge());
		girlEntity.setCupSize(vo.getCupSize());
		return ResultUtils.seccess(girlDaoI.save(girlEntity));
	}

	@DeleteMapping(value = "/doGirlDelete/{id}")
	@ApiOperation(value = "删除用户Girl", notes = "根据用户的id来删除用户Girl")
	@ApiImplicitParam(name = "id", value = "Girl的ID", required = true, paramType = "query", dataType = "String")
	public void doDelete(@PathVariable(name = "id") String id) {
		girlDaoI.delete(id);
	}

	@PutMapping(value = "/doGirlUpdate/{id}")
	@ApiOperation(value = "更改用户Girl", notes = "通过id更新用户girl信息")
	public void doUpdate(@PathVariable(name = "id") String id, GirlVO vo) {
		GirlEntity girlEntity = new GirlEntity();
		girlEntity.setId(id);
		girlEntity.setName(vo.getName());
		girlEntity.setAge(vo.getAge());
		girlDaoI.save(girlEntity);
	}

	@GetMapping(value = "/doGirlList")
	@ApiOperation(value = "获取用户Girl列表", notes = "获取用户Girl列表")
	public Result<GirlEntity> doGirlList() {
		return ResultUtils.seccess(girlDaoI.findAll());
	}

	@GetMapping(value = "/getGirlAge/{id}")
	public Result<GirlEntity> getGirlAge(@PathVariable("id") String id) throws Exception {
		girlServiceI.getAge(id);
		return ResultUtils.seccess();
	}
}
