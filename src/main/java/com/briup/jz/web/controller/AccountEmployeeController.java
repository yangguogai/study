package com.briup.jz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.service.AccountEmployeeService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "账户员工分类相关接口")
@Validated
@RestController
@RequestMapping("/accountEmployee")
public class AccountEmployeeController {

	@Autowired
	private AccountEmployeeService accountEmployeeService;

	// 根据id查询员工银行账户充值提现信息
	@ApiOperation(value = "查询账户消费信息")
	@GetMapping("query")
	public Message query(long id) {
		AccountEmployee list = accountEmployeeService.queryAccountEmployeeById(id);
		return MessageUtil.success(list);
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新资员工银行卡消费信息")

	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(AccountEmployee AccountEmployee) {
		accountEmployeeService.saveOrUpdate(AccountEmployee);
		return MessageUtil.success("更新成功");
	}

	// 删除一个id信息
	@ApiOperation(value = "删除员工银行账户消费信息")
	@PostMapping("/deleteById")
	public Message deleteById(long id) {
		accountEmployeeService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

}
