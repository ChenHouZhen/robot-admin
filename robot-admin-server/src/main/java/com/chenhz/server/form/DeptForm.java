package com.chenhz.server.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "部门新增表单")
public class DeptForm {

    @ApiModelProperty(value = "父级ID")
    private Long pid;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;


}
