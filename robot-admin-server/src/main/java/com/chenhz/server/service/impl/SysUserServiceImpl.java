package com.chenhz.server.service.impl;

import com.chenhz.server.entity.SysUserEntity;
import com.chenhz.server.mapper.SysUserMapper;
import com.chenhz.server.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
