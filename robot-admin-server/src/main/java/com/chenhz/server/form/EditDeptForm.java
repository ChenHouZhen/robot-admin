package com.chenhz.server.form;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author CHZ
 * @create 2019/12/13
 */
public class EditDeptForm {

    @ApiModelProperty(value = "父级ID")
    private Long id;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;
}
