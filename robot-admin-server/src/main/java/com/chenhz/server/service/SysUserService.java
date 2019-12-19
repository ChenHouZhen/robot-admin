package com.chenhz.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhz.server.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhz.server.form.UserInfoForm;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
public interface SysUserService extends IService<SysUserEntity> {

    Page page(UserInfoForm form);
}
