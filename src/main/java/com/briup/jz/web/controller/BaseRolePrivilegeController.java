package com.briup.jz.web.controller;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.service.IBaseRolePrivilegeService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "yqb角色权限 相关接口")
@Validated
@RestController
@RequestMapping("/baseRolePrivilege")

public class BaseRolePrivilegeController {

	@Autowired
	private IBaseRolePrivilegeService ibaseRolePrivilegeService;

	// 根据id 查詢 
	@ApiOperation(value = "查询所有角色权限 ")
	@GetMapping("/query")
	
	public Message query(Long id) {

		List<BaseRolePrivilege> list = ibaseRolePrivilegeService.query(id);

		return MessageUtil.success(list);
	}

	// 根据id删除
	@ApiOperation(value = "通过id删除角色")
	@GetMapping("/deleteById")

	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })
	public Message deleteById(@NotNull Long id) {

		ibaseRolePrivilegeService.deleteById(id);

		return MessageUtil.success("删除成功");
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新角色")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),
			@ApiImplicitParam(name = "roleId", value = "栏目角色id", paramType = "form"),

			@ApiImplicitParam(name = "privilegeId", value = "权限id", paramType = "form"), })
	@PostMapping("/saveOrUpdate")

	public Message saveOrUpdate(BaseRolePrivilege baseRolePrivilege) {

		ibaseRolePrivilegeService.saveOrUpdate(baseRolePrivilege);

		return MessageUtil.success("更新成功");
	}

}
