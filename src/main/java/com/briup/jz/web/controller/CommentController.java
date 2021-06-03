package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Comment;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="资讯分类相关接口")
@Validated
@RestController
@RequestMapping("/comment")
public class CommentController{
	 @Autowired
	    private ICommentService commentService;

	    @ApiOperation(value = "查询所有资讯分类")
	    @GetMapping("query")
	    public Message query(String name){
	        List<Comment> list = commentService.query(name);
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	    	commentService.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value = "保存或更新资讯分类信息")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "序号",paramType = "form"),
	            @ApiImplicitParam(name="comment",value = "评价内容",paramType = "form",required = true),
	            @ApiImplicitParam(name="comment—time",value = "评价时间",paramType = "form"),
	            @ApiImplicitParam(name="status",value = "是否通过",paramType = "form"),
	            @ApiImplicitParam(name="user_id",value = "用户编号",paramType = "form"),
	            @ApiImplicitParam(name="article_id",value = "文章编号",paramType = "form"),
	            @ApiImplicitParam(name="parentId",value = "   ",paramType = "form"),
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(Comment comment){
	    	commentService.saveOrUpdate(comment);
	        return MessageUtil.success("更新成功");
	    }
}
