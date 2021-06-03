package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.service.OrderComment;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="订单说明分类")
	@Validated
	@RestController
	@RequestMapping("/orderComment")
	public class OrderCommentController {

	    @Autowired
	    private OrderComment orderComment;

	    @ApiOperation(value = "查询所有订单说明分类")
	    @GetMapping("query")
	    public Message query(String name){
	        List<OrderComment> list = orderComment.query(name);
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "form", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	       orderComment.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value = "保存或更新订单说明分类信息")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
	            @ApiImplicitParam(name="name",value = "栏目名称",paramType = "form",required = true),
	            @ApiImplicitParam(name="description",value = "栏目描述",paramType = "form"),
	            @ApiImplicitParam(name="no",value = "序号",paramType = "form"),
	            @ApiImplicitParam(name="parentId",value = "父栏目id",paramType = "form"),
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(OrderComment orderComment){
	       orderComment.saveOrUpdate(orderComment);
	        return MessageUtil.success("更新成功");
	    }
}

	


