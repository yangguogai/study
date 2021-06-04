package com.briup.jz.web.controller;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.service.IBaseUserService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "yqb用户表相关接口")
@Validated
@RestController
@RequestMapping("/baseUser")

public class BaseUserController {

	@Autowired
	private IBaseUserService ibaseUserService;

	// 根据名字模糊查询所有分类
	@ApiOperation(value = "查询所有用户表")
	@GetMapping("/query")

	public Message query(String username) {

		List<BaseUser> list = ibaseUserService.query(username);

		return MessageUtil.success(list);
	}

	// 根据id删除。。
	@ApiOperation(value = "通过id删除用户表")
	@GetMapping("/deleteById")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })

	public Message deleteById(@NotNull Long id) {

		ibaseUserService.deleteById(id);

		return MessageUtil.success("删除成功");
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新用户表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),

			@ApiImplicitParam(name = "username", value = "栏目名称", paramType = "form", required = true),

			@ApiImplicitParam(name = "password", value = "栏目密码", paramType = "form"),

			@ApiImplicitParam(name = "telephone", value = "栏目电话", paramType = "form"),

			@ApiImplicitParam(name = "realname", value = "栏目姓名", paramType = "form"),

			@ApiImplicitParam(name = "gender", value = "栏目性別", paramType = "form"),

			@ApiImplicitParam(name = "birth", value = "栏目生日", paramType = "form"),

			@ApiImplicitParam(name = "email", value = "栏目邮箱", paramType = "form"),

			@ApiImplicitParam(name = "status", value = "栏目状态", paramType = "form"),

			@ApiImplicitParam(name = "userFace", value = "栏目地址", paramType = "form"),

			@ApiImplicitParam(name = "registerTime", value = "registerTime", paramType = "form"),

			@ApiImplicitParam(name = "nation", value = "栏目民族", paramType = "form"),

			@ApiImplicitParam(name = "idCard", value = "栏目id卡", paramType = "form"),

			@ApiImplicitParam(name = "idcardPhotoPositive", value = "栏目照片", paramType = "form"),

			@ApiImplicitParam(name = "idcardPhotoNegative", value = "idcardPhotoNegative", paramType = "form"),

			@ApiImplicitParam(name = "bankCard", value = "栏目银行卡", paramType = "form"),

			@ApiImplicitParam(name = "bankCardPhoto", value = "栏目银行卡照片", paramType = "form"),

			@ApiImplicitParam(name = "balance", value = "栏目余额", paramType = "form"),

			@ApiImplicitParam(name = "certificationStatus", value = "栏目状态", paramType = "form"),

			@ApiImplicitParam(name = "bankCardPhoto", value = "栏目银行照片", paramType = "form"),

			@ApiImplicitParam(name = "certificationTime", value = "栏目", paramType = "form"),

	})
	@PostMapping("/saveOrUpdate")
	
	public Message saveOrUpdate(BaseUser baseUser) {

		ibaseUserService.saveOrUpdate(baseUser);

		return MessageUtil.success("更新成功");
	}

}
