package com.briup.jz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountSystem;
import com.briup.jz.service.AccountSystemService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "系统账户分类相关接口")
@Validated
@RestController
@RequestMapping("/accountSystem")
public class AccountSystemController {

	@Autowired
	private AccountSystemService accountSystemService;

	// 根据id查询员工银行账户充值提现信息
	@ApiOperation(value = "查询系统账户信息")
	@GetMapping("query")
	public Message query(long id) {
		AccountSystem list = accountSystemService.queryAccountSystemById(id);
		return MessageUtil.success(list);
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新系统账户信息")
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(AccountSystem AccountSystem) {
		accountSystemService.saveOrUpdate(AccountSystem);
		return MessageUtil.success("更新成功");
	}

	// 删除一个id信息
	@ApiOperation(value = "删除系统账户信息")
	@PostMapping("/deleteById")
	public Message deleteById(long id) {
		accountSystemService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

}
