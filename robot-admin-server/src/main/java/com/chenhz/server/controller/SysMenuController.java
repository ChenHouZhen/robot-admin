package com.chenhz.server.controller;


import com.chenhz.server.service.SysMenuService;
import com.chenhz.server.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}
