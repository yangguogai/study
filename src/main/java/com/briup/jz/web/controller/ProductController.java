package com.briup.jz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Product;
import com.briup.jz.service.ProductService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(description = "产品相关接口")
@Validated
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// 根据id查询银行账户充值提现信息
	@ApiOperation(value = "查询所有产品信息")
	@GetMapping("query")
	public Message query(long id) {
		Product list = productService.queryProductByid(id);
		return MessageUtil.success(list);
	}

	// 保存或者更新
	@ApiOperation(value = "保存或更新产品信息")
	@ApiImplicitParam(name = "name", value = "栏目名称", paramType = "form", required = true)
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(Product product) {
		productService.saveOrUpdate(product);
		return MessageUtil.success("更新成功");
	}

	// 删除一个id信息
	@ApiOperation(value = "删除银行账户信息")
	@PostMapping("/deleteById")
	public Message deleteById(long id) {
		productService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

}
