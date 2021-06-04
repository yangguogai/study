package com.briup.jz.web.controller;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.Category;
import com.briup.jz.bean.CertificationApply;
import com.briup.jz.service.ICategoryService;
import com.briup.jz.service.ICertificationApplyService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "yqb实名认证申请表相关接口")
@Validated
@RestController

@RequestMapping("/certificationApply")
public class CertificationApplyController {

	@Autowired
	private ICertificationApplyService icertificationApplyService;

	// 根据名字模糊查询所有分类
	@ApiOperation(value = "查询所有实名认证表")
	@GetMapping("/query")

	public Message query(String name) {

		List<CertificationApply> list = icertificationApplyService.query(name);

		return MessageUtil.success(list);
	}

	// 根据id删除
	@ApiOperation(value = "通过id删除认证表")

	@GetMapping("/deleteById")

	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true), })
	public Message deleteById(@NotNull Long id) {

		icertificationApplyService.deleteById(id);

		return MessageUtil.success("删除成功");
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新实名认证表")
	@ApiImplicitParams({

			@ApiImplicitParam(name = "id", value = "主键", paramType = "form"),
			@ApiImplicitParam(name = "realname", value = "realname", paramType = "form", required = true),
			@ApiImplicitParam(name = "idCard", value = "idCard", paramType = "form"),
			@ApiImplicitParam(name = "idcardPhotoPositive", value = "idcardPhotoPositive", paramType = "form"),
			@ApiImplicitParam(name = "idcardPhotoNegative", value = "idcardPhotoNegative", paramType = "form"),
			@ApiImplicitParam(name = "bankCard", value = "bankCard", paramType = "form"),
			@ApiImplicitParam(name = "bankCardPhoto", value = "bankCardPhoto", paramType = "form"),
			@ApiImplicitParam(name = "status", value = "status", paramType = "form"),
			@ApiImplicitParam(name = "applyTime", value = "applyTime", paramType = "form"),
			@ApiImplicitParam(name = "reason", value = "reason", paramType = "form"),
			@ApiImplicitParam(name = "userId", value = "userId", paramType = "form"),

	})

	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(CertificationApply certificationApply) {

		icertificationApplyService.saveOrUpdate(certificationApply);
		
		return MessageUtil.success("更新成功");
	}
}
