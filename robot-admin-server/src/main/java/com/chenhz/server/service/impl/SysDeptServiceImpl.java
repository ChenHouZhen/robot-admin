package com.chenhz.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenhz.server.dto.Node;
import com.chenhz.server.entity.SysDeptEntity;
import com.chenhz.server.form.DeptInfoForm;
import com.chenhz.server.mapper.SysDeptMapper;
import com.chenhz.server.service.SysDeptService;
import com.chenhz.server.utils.PageUtils;
import com.chenhz.server.utils.TreeBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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
                .orderByAsc(SysDeptEntity::getOrderNum)
        );

        return page;
    }

    @Override
    public List<Node> tree() {
        List<SysDeptEntity> all = this.list();

        List<Node> data = all.stream()
                .map(this::entity2dto)
                .collect(Collectors.toList());

        return TreeBuilder.buildListToTree(data);
    }


    private Node entity2dto(SysDeptEntity entity){
        Node dto = new Node();
        dto.setId(entity.getDeptId());
        dto.setName(entity.getName());
        dto.setPId(entity.getParentId());
        return dto;
    }
}
