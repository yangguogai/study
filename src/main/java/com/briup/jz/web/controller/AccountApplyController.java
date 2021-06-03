package com.briup.jz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.service.AccountApplyService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "银行账户分类相关接口")
@Validated
@RestController
@RequestMapping("/accountApplay")
public class AccountApplyController {

	@Autowired
	private AccountApplyService accountApplyService;

	// 根据id查询银行账户充值提现信息
	@ApiOperation(value = "查询所有银行账户信息")
	@GetMapping("queryAllAccount")
	public Message query(long id) {
		AccountApply list = accountApplyService.queryAccountApplyByid(id);
		return MessageUtil.success(list);
	}

}
