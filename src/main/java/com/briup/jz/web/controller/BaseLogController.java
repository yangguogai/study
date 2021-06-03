package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseLog;
import com.briup.jz.service.IBaseLogService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="日志相关接口")
@Validated
@RestController
@RequestMapping("/baseLog")
public class BaseLogController {
	@Autowired
    private IBaseLogService baseLogService;

    @ApiOperation(value = "查询所有日志信息分类")
    @GetMapping("query")
    public Message query(String realname){
        List<BaseLog> list = baseLogService.query(realname);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	baseLogService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新日志分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name="realname",value = "姓名",paramType = "form",required = true),
            @ApiImplicitParam(name="method",value = "提交方法",paramType = "form"),
            @ApiImplicitParam(name="content",value = "提交内容",paramType = "form"),
            @ApiImplicitParam(name="logTime",value = "日志时间",paramType = "form"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseLog baseLog){
    	baseLogService.saveOrUpdate(baseLog);
        return MessageUtil.success("更新成功");
    }
}
