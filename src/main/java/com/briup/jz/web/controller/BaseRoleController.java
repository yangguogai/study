package com.briup.jz.web.controller;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.BaseRole;
import com.briup.jz.service.IBaseRoleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "yqb角色表相关接口")
@Validated
@RestController

@RequestMapping("/baseRole")
public class BaseRoleController {

	@Autowired
	private IBaseRoleService ibaseRoleService;

	// 根据名字模糊查询所有分类
	@ApiOperation(value = "查询所有角色表")
	@GetMapping("/query")

	public Message query(String username) {
		
		List<BaseRole> list = ibaseRoleService.query(username);
		
		return MessageUtil.success(list);
	}

	// 根据id删除
	
	@ApiOperation(value = "通过id删除")
	@GetMapping("/deleteById")
	
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })
	
	public Message deleteById(@NotNull Long id) {
		
		ibaseRoleService.deleteById(id);
		
		return MessageUtil.success("删除成功");
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新角色表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),

			@ApiImplicitParam(name = "name", value = "栏目姓名", paramType = "form"),

	})
	
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(BaseRole baseRole) {

		ibaseRoleService.saveOrUpdate(baseRole);

		return MessageUtil.success("更新成功");
	}

}
