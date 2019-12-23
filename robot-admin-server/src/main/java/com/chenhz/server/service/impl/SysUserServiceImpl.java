package com.chenhz.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenhz.server.entity.SysUserEntity;
import com.chenhz.server.form.UserInfoForm;
import com.chenhz.server.mapper.SysUserMapper;
import com.chenhz.server.service.SysUserService;
import com.chenhz.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public Page page(UserInfoForm form) {
        Page page = new Page(PageUtils.getPage(form),PageUtils.getLimit(form));

        this.page(page, new LambdaQueryWrapper<SysUserEntity>()
                .eq(!StringUtils.isEmpty(form.getStatus()),SysUserEntity::getStatus,form.getStatus())
                .eq(!StringUtils.isEmpty(form.getDeptId()),SysUserEntity::getDeptId,form.getDeptId())
                .like(!StringUtils.isEmpty(form.getUserName()),SysUserEntity::getUsername,form.getUserName())
                .like(!StringUtils.isEmpty(form.getPhone()),SysUserEntity::getMobile,form.getPhone())
                .gt(!StringUtils.isEmpty(form.getStartTime()),SysUserEntity::getCreateTime,form.getStartTime())
                .lt(!StringUtils.isEmpty(form.getEndTime()),SysUserEntity::getCreateTime,form.getEndTime())
                .orderByDesc(SysUserEntity::getCreateTime)
        );

        return page;
    }
}
