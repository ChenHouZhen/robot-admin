package com.chenhz.server.controller;


import com.chenhz.server.form.FileInfoForm;
import com.chenhz.server.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文件资源表 前端控制器
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
@Slf4j
@RestController
@RequestMapping("/file")
@Api(tags = "文件管理")
public class SysFileController {

    @GetMapping(value = "/{fileId}")
    @ApiOperation("查询")
    public R info(@PathVariable Long fileId){
        return R.ok().put("data",fileId);
    }

    @GetMapping()
    @ApiOperation("查询")
    public R infos(FileInfoForm form){
        return R.ok().put("data",form);
    }


    @DeleteMapping("/{fileId}")
    @ApiOperation("删除")
    public R delete(@PathVariable Long fileId){
        return R.ok().put("data",fileId);
    }
}
