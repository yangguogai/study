package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Address;
import com.briup.jz.service.IAddressService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="顾客地址")
@Validated
@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
    private IAddressService addressService;

    @ApiOperation(value = "查询所有顾客地址信息")
    @GetMapping("query")
    public Message query(String id){
        List<Address> list = addressService.query(id);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
        addressService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新资讯分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name="username",value = "用户名称",paramType = "form",required = true),
            @ApiImplicitParam(name="telephone",value = "电话",paramType = "form"),
            @ApiImplicitParam(name="province",value = "省份",paramType = "form"),
            @ApiImplicitParam(name="city",value = "城市",paramType = "form"),
            @ApiImplicitParam(name="area",value = "区域",paramType = "form"),
            @ApiImplicitParam(name="address",value = "地址",paramType = "form"),
            @ApiImplicitParam(name="isefault",value = "违约记录",paramType = "form"),
            @ApiImplicitParam(name="userId",value = "用户id",paramType = "form")
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Address address){
        addressService.saveOrUpdate(address);
        return MessageUtil.success("更新成功");
    }
}


