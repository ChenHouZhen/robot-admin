package com.chenhz.server.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhz.server.service.SysMenuService;
import com.chenhz.server.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author chenhz
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "菜单管理")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping(value = "/list")
    @ApiOperation("获取全部菜单")
    public R list(){
        return R.ok().put("data",sysMenuService.list());
    }

    @GetMapping(value = "/get")
    @ApiOperation("获取全部菜单")
    public R get(Long id){
        return R.ok().put("dat",sysMenuService.getById(id));
    }


    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer", defaultValue = "1", name = "current", value = "当前页"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", defaultValue = "10", name = "size", value = "每页记录数"),
    })
    public R page(long current, long size){
        return R.ok().put("data",sysMenuService.page(new Page<>(current,size)));
    }
}
