package com.chenhz.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhz.server.dto.Node;
import com.chenhz.server.entity.SysDeptEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhz.server.form.DeptInfoForm;

import java.util.List;

/**
 * <p>
 * 部门管理 服务类
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
public interface SysDeptService extends IService<SysDeptEntity> {


    Page page(DeptInfoForm form);


    List<Node> tree();

}
