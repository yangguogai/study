package com.briup.jz.web.controller;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.BasePrivilege;
import com.briup.jz.service.IBasePrivilegeService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "yqb权限表分类相关接口")
@Validated
@RestController
@RequestMapping("/basePrivilege")

public class BasePrivilegeController {

	@Autowired
	private IBasePrivilegeService ibasePrivilegeService;
	

	// 根据名字模糊查询所有分类
	@ApiOperation(value = "查询所有权限表")
	@GetMapping("/query")
	public Message query(String name) {

		List<BasePrivilege> list = ibasePrivilegeService.query(name);
		
		return MessageUtil.success(list);
	}

	
	// 根据id删除
	@ApiOperation(value = "通过id删除")
	@GetMapping("/deleteById")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })
	public Message deleteById(@NotNull Long id) {
		
		ibasePrivilegeService.deleteById(id);
		
		return MessageUtil.success("删除成功");
	}

	
	// 保存或者更新
	@ApiOperation(value = "保存或更新权限表")
	
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),
			@ApiImplicitParam(name = "name", value = "栏目名称", paramType = "form", required = true),
			@ApiImplicitParam(name = "description", value = "栏目描述", paramType = "form"),
			@ApiImplicitParam(name = "route", value = "route", paramType = "form"),
			@ApiImplicitParam(name = "routeName", value = "routeName", paramType = "form"),
			@ApiImplicitParam(name = "type", value = "type", paramType = "form"),
			@ApiImplicitParam(name = "icon", value = "icon", paramType = "form"),
			@ApiImplicitParam(name = "hidden", value = "hidden", paramType = "form"),
			@ApiImplicitParam(name = "num", value = "num", paramType = "form"),
			@ApiImplicitParam(name = "parentId", value = "parentId", paramType = "form"),

	})
	
	@PostMapping("/saveOrUpdate")
	
	public Message saveOrUpdate(BasePrivilege basePrivilege) {
		
		ibasePrivilegeService.saveOrUpdate(basePrivilege);
		
		return MessageUtil.success("更新成功");
	}
}
