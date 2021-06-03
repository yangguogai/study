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
import com.briup.jz.bean.Category;
import com.briup.jz.service.ICertificationApplyService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "实名认证相关接口")
@Validated
@RestController
@RequestMapping("/certificationApply")
public class CertificationApplyController {

	@Autowired
	private ICertificationApplyService iCertificationApplyService;

	// 根据名字模糊查询所有分类
	@ApiOperation(value = "查询所有资讯分类")
	@GetMapping("/query")

	public Message query(String username) {
		List<BaseUser> list = iCertificationApplyService.query(username);
		return MessageUtil.success(list);
	}

	// 根据id删除
	@ApiOperation(value = "通过id删除")
	@GetMapping("/deleteById")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })
	public Message deleteById(@NotNull Long id) {
		iCertificationApplyService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新资讯分类信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),

			@ApiImplicitParam(name = "username", value = "栏目名称", paramType = "form", required = true),

			@ApiImplicitParam(name = "password", value = "栏目密码", paramType = "form"),

			@ApiImplicitParam(name = "telephone", value = "栏目电话", paramType = "form"),

			@ApiImplicitParam(name = "realname", value = "栏目真名", paramType = "form"),

			@ApiImplicitParam(name = "gender", value = "栏目性別", paramType = "form"),
			
			@ApiImplicitParam(name = "birth", value = "栏目生日", paramType = "form"),
			
			@ApiImplicitParam(name = "email", value = "栏目邮箱", paramType = "form"),
			
			@ApiImplicitParam(name = "status", value = "栏目状态", paramType = "form"),
			
			@ApiImplicitParam(name = "userFace", value = "栏目地址", paramType = "form"),
			
			@ApiImplicitParam(name = "registerTime", value = "栏目描述", paramType = "form"),
			
			@ApiImplicitParam(name = "nation", value = "栏目名族", paramType = "form"),
			
			@ApiImplicitParam(name = "idCard", value = "栏目卡", paramType = "form"),
			
			@ApiImplicitParam(name = "idcardPhotoPositive", value = "栏目照片", paramType = "form"),
			
			@ApiImplicitParam(name = "idcardPhotoNegative", value = "栏目", paramType = "form"),
			
			@ApiImplicitParam(name = "bankCard", value = "栏目银行卡", paramType = "form"),
			
			
			@ApiImplicitParam(name = "bankCardPhoto", value = "栏目银行卡照片", paramType = "form"),
			
			@ApiImplicitParam(name = "balance", value = "栏目余额", paramType = "form"),
			
			@ApiImplicitParam(name = "certificationStatus", value = "栏目状态", paramType = "form"),
			
			@ApiImplicitParam(name = "bankCardPhoto", value = "栏目照片", paramType = "form"),
			
			@ApiImplicitParam(name = "certificationTime", value = "栏目", paramType = "form"),
			

	})
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(BaseUser baseUser) {

		iCertificationApplyService.saveOrUpdate(baseUser);

		return MessageUtil.success("更新成功");
	}

}
