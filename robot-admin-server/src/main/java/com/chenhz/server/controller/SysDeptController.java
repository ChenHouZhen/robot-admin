package com.chenhz.server.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhz.server.dto.Node;
import com.chenhz.server.entity.SysDeptEntity;
import com.chenhz.server.form.DeptForm;
import com.chenhz.server.form.DeptInfoForm;
import com.chenhz.server.service.SysDeptService;
import com.chenhz.server.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
@Slf4j
@RestController
@RequestMapping("/v1/dept")
@Api(tags = "部门管理")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping()
    @ApiOperation("新增")
    public R add(@RequestBody DeptForm form){

        SysDeptEntity entity = new SysDeptEntity();
        entity.setCreateTime(new Date());
        entity.setName(form.getDeptName());
        entity.setOrderNum(form.getOrderNum());
        entity.setParentId(form.getPid());

        sysDeptService.save(entity);

        return R.ok().put("data",sysDeptService.getById(entity.getDeptId()));
    }

    @PutMapping(value = "/{deptId}")
    @ApiOperation("修改")
    public R edit(@PathVariable Long deptId,@RequestBody DeptForm form){

        SysDeptEntity entity = new SysDeptEntity();
        entity.setDeptId(deptId);
        entity.setName(form.getDeptName());
        entity.setOrderNum(form.getOrderNum());
        entity.setParentId(form.getPid());

        sysDeptService.updateById(entity);

        return R.ok().put("data",entity);
    }

    @GetMapping(value = "/{deptId}")
    @ApiOperation("查询")
    public R info(@PathVariable Long deptId){

        return R.ok().put("data",sysDeptService.getById(deptId));
    }


    @GetMapping()
    @ApiOperation("查询")
    public R infos(DeptInfoForm form){
        Page data = sysDeptService.page(form);
        return R.ok().put("data",data);
    }


    @GetMapping("/tree")
    @ApiOperation("查询部门树")
    public R tree(){
        List<Node> data = sysDeptService.tree();
        return R.ok().put("data",data);
    }


    @DeleteMapping("/{deptId}")
    @ApiOperation("删除")
    public R delete(@PathVariable Long deptId){
        SysDeptEntity entity = new SysDeptEntity();
        entity.setDeptId(deptId);
        entity.setDelFlag(-1);
        Boolean result =  sysDeptService.updateById(entity);

        return R.ok().put("data",result);
    }

}
