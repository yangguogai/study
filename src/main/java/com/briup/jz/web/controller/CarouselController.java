package com.briup.jz.web.controller;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.jz.bean.Carousel;
import com.briup.jz.bean.Category;
import com.briup.jz.service.ICarouselService;
import com.briup.jz.service.ICategoryService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="轮播图分类相关接口")
@Validated
@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private ICarouselService carouselService;

    @ApiOperation(value = "查询所有轮播图分类")
    @GetMapping("query")
    public Message query(String name){
        List<Carousel> list = carouselService.query(name);
        return MessageUtil.success(list);
    }



    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	carouselService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新轮播图分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "序号",paramType = "form"),
            @ApiImplicitParam(name="name",value = "名称",paramType = "form",required = true),
            @ApiImplicitParam(name="introduce",value = "介绍",paramType = "form"),
            @ApiImplicitParam(name="url",value = "地址",paramType = "form"),
            @ApiImplicitParam(name="status",value = "状态",paramType = "form"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Carousel carousel){
    	carouselService.saveOrUpdate(carousel);
        return MessageUtil.success("更新成功");
    }
}
