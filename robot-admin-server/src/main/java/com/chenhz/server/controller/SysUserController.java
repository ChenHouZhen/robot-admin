package com.chenhz.server.controller;


import com.chenhz.server.form.UserForm;
import com.chenhz.server.form.UserInfoForm;
import com.chenhz.server.service.SysUserService;
import com.chenhz.server.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping()
    @ApiOperation("新增")
    public R add(@RequestBody UserForm form){
        return R.ok().put("data",form);
    }

    @PutMapping(value = "/{userId}")
    @ApiOperation("修改")
    public R edit(@PathVariable(value = "userId") Long userId,@RequestBody UserForm form){
        return R.ok().put("data",userId);
    }

    @GetMapping(value = "/{userId}")
    @ApiOperation("查询")
    public R info(@PathVariable(value = "userId") Long userId){
        return R.ok().put("data",userId);
    }

    @GetMapping()
    @ApiOperation("查询")
    public R infos(UserInfoForm form){
        return R.ok().put("data",form);
    }

}
