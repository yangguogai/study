package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseFile;
import com.briup.jz.service.IBaseFileService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="附件表分类相关接口")
@Validated
@RestController
@RequestMapping("/baseFile")
public class BaseFileController {
	@Autowired
    private IBaseFileService baseFileService;

    @ApiOperation(value = "查询所有附件表分类")
    @GetMapping("query")
    public Message query(String filename){
        List<BaseFile> list = baseFileService.query(filename);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull String id){
    	baseFileService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新附件表分类信息")
   @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name="fileName",value = "附件名称",paramType = "form",required = true),
            @ApiImplicitParam(name="groupName",value = "栏目描述",paramType = "form"),
            @ApiImplicitParam(name="uploadTime",value = "更新时间",paramType = "form"),
            @ApiImplicitParam(name="extName",value = "名字",paramType = "form"),
            @ApiImplicitParam(name="fileSize",value = "附件大小",paramType = "form"),
            @ApiImplicitParam(name="fileType",value = "附件类型",paramType = "form"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseFile baseFile){
    	baseFileService.saveOrUpdate(baseFile);
        return MessageUtil.success("更新成功");
    }
}
