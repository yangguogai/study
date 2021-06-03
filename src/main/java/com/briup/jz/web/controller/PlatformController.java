package com.briup.jz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.Platform;
import com.briup.jz.service.PlatformService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "平台账户分类相关接口")
@Validated
@RestController
@RequestMapping("/platform")
public class PlatformController {

	@Autowired
	private PlatformService platformService;

	// 根据id查询平台账户信息
	@ApiOperation(value = "查询平台账户信息")
	@GetMapping("query")
	public Message query(long id) {
		Platform list = platformService.queryPlatformById(id);
		return MessageUtil.success(list);
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新平台账户信息")
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(Platform Platform) {
		platformService.saveOrUpdate(Platform);
		return MessageUtil.success("更新成功");
	}

	// 删除一个id信息
	@ApiOperation(value = "删除平台账户信息")
	@PostMapping("/deleteById")
	public Message deleteById(long id) {
		platformService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
}
