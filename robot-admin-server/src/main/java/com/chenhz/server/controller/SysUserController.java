package com.chenhz.server.controller;


import com.chenhz.server.service.SysUserService;
import com.chenhz.server.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
@Slf4j
@RestController
@RequestMapping("/v1/users")
@Api(tags = "用户管理")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("/add")
    @ApiOperation("新增")
    public R add(){
        return R.ok();
    }

}
