package com.briup.jz.web.controller;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.BaseUserRole;
import com.briup.jz.service.IBaseUserRoleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "yqb用户角色相关接口")
@Validated
@RestController
@RequestMapping("/baseUserRole")
public class BaseUserRoleController {

	@Autowired
	private IBaseUserRoleService ibaseUserRoleService;

	// 根据名字模糊查询所有分类
	@ApiOperation(value = "查询所有用户角色")
	@GetMapping("/query")

	public Message query(Long  id) {

		List<BaseUserRole> list = ibaseUserRoleService.query(id);

		return MessageUtil.success(list);
	}

	// 根据id删除
	@ApiOperation(value = "通过id删除用户角色")
	@GetMapping("/deleteById")

	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })
	public Message deleteById(@NotNull Long id) {

		ibaseUserRoleService.deleteById(id);

		return MessageUtil.success("删除成功");
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新用戶角色")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),

			@ApiImplicitParam(name = "userId", value = "用戶id", paramType = "form"),
			@ApiImplicitParam(name = "roleId", value = "角色id ", paramType = "form"), })
	@PostMapping("/saveOrUpdate")

	public Message saveOrUpdate(BaseUserRole baseUserRole) {

		ibaseUserRoleService.saveOrUpdate(baseUserRole);

		return MessageUtil.success("更新成功");
	}
}
