package com.chenhz.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhz.server.entity.SysDeptEntity;
import com.chenhz.server.form.DeptInfoForm;
import com.chenhz.server.mapper.SysDeptMapper;
import com.chenhz.server.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenhz.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements SysDeptService {

    @Override
    public Page page(DeptInfoForm form) {
        Page page = new Page(PageUtils.getPage(form),PageUtils.getLimit(form));
        this.page(page, new LambdaQueryWrapper<SysDeptEntity>()
                .like(!StringUtils.isEmpty(form.getDeptName()), SysDeptEntity::getName,form.getDeptName())
                .gt(!StringUtils.isEmpty(form.getStartTime()),SysDeptEntity::getCreateTime,form.getStartTime())
                .lt(!StringUtils.isEmpty(form.getEndTime()),SysDeptEntity::getCreateTime,form.getEndTime())
                .eq(!StringUtils.isEmpty(form.getStatus()),SysDeptEntity::getDelFlag,form.getStatus())
                .eq(!StringUtils.isEmpty(form.getPDeptId()),SysDeptEntity::getParentId,form.getPDeptId())
        );

        return page;
    }
}
