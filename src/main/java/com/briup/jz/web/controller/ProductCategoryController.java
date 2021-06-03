package com.briup.jz.web.controller;

import java.util.List;


import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.ProductCategory;
import com.briup.jz.service.IProductCategoryService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api(description="产品分类")
@Validated
@RestController
@RequestMapping("productcategory")
public class ProductCategoryController {
	 @Autowired
	    private IProductCategoryService productcategoryService;

	    @ApiOperation(value = "查询所有产品分类")
	    @GetMapping("query")
	    public Message query(String name){
	        List<ProductCategory> list = productcategoryService.query(name);
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "form", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	        productcategoryService.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value = "保存或更新产品分类的信息")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
	            @ApiImplicitParam(name="name",value = "栏目名称",paramType = "form",required = true),
	            @ApiImplicitParam(name="icon",value = "地址",paramType = "form"),
	            @ApiImplicitParam(name="num",value = "号码",paramType = "form"),
	            @ApiImplicitParam(name="parentId",value = "父栏目id",paramType = "form"),
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(ProductCategory productcategory){
	        productcategoryService.saveOrUpdate(productcategory);
	        return MessageUtil.success("更新成功");
	    }
	}


