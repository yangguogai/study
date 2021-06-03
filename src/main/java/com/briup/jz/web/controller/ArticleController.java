package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Article;
import com.briup.jz.service.IArticleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="资讯分类相关接口")
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {
	 @Autowired
	    private IArticleService articleService;

	    @ApiOperation(value = "查询所有资讯分类")
	    @GetMapping("query")
	    public Message query(String name){
	        List<Article> list = articleService.query(name);
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	        articleService.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value = "保存或更新资讯分类信息")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
	            @ApiImplicitParam(name="name",value = "栏目名称",paramType = "form",required = true),
	            @ApiImplicitParam(name="description",value = "栏目描述",paramType = "form"),
	            @ApiImplicitParam(name="no",value = "序号",paramType = "form"),
	            @ApiImplicitParam(name="parentId",value = "父栏目id",paramType = "form"),
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(Article article){
	        articleService.saveOrUpdate(article);
	        return MessageUtil.success("更新成功");
	    }
}
