package com.briup.jz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.service.AccountApplyService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "账户变动申请表（提现）相关接口")
@Validated
@RestController
@RequestMapping("/accountApplay")
public class AccountApplyController {

	@Autowired
	private AccountApplyService accountApplyService;

	// 查询账户变动申请表信息
	@ApiOperation(value = "查询账户变动申请表信息")
	@GetMapping("query")
	@ApiImplicitParams({
		@ApiImplicitParam(name="AccountType",value="申请类型（提现、充值）",paramType = "from"),
		@ApiImplicitParam(name="status",value="申请状态")
	})
	public Message query(String AccountType,String status) {
		List<AccountApply> list = accountApplyService.query(AccountType, status);
		return MessageUtil.success(list);
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新资银行卡类信息")
	@ApiImplicitParam(name = "name", value = "栏目名称", paramType = "form", required = true)
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(AccountApply accountApply) {
		accountApplyService.saveOrUpdate(accountApply);
		return MessageUtil.success("更新成功");
	}

	// 删除一个id信息
	@ApiOperation(value = "删除银行账户信息")
	@PostMapping("/deleteById")
	public Message deleteById(long id) {
		accountApplyService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

}
