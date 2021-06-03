package com.briup.jz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.service.AccountCustomerService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(description = "银行顾客分类相关接口")
@Validated
@RestController
@RequestMapping("/accountCustomer")
public class AccountCustomerController {

	@Autowired
	private AccountCustomerService accountCustomerService;
	
		// 根据id查询顾客银行账户充值提现信息
		@ApiOperation(value = "查询顾客账户消费信息")
		@GetMapping("queryAccountCustomer")
		public Message query(long id) {
			AccountCustomer list = accountCustomerService.queryAccountCustomerById(id);
			return MessageUtil.success(list);
		}
		
		//保存或者更新
		@ApiOperation(value="保存或更新资顾客银行卡消费信息")
		
		@PostMapping("/saveOrUpdate")
		public Message saveOrUpdate(AccountCustomer accountCustomer) {
			accountCustomerService.saveOrUpdate(accountCustomer);
			return MessageUtil.success("更新成功");
		}
		
		//删除一个id信息
		@ApiOperation(value = "删除顾客银行账户消费信息")
		@PostMapping("/deleteById")
		public Message deleteById(long id) {
			accountCustomerService.deleteById(id);
			return MessageUtil.success("删除成功");
		}
	
}
