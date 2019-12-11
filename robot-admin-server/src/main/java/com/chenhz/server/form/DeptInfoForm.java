package com.chenhz.server.form;

import com.chenhz.server.form.base.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "部门查询表单")
public class DeptInfoForm extends PageForm {


    @ApiModelProperty("名称")
    private String deptName;

    @ApiModelProperty("父ID")
    private Long pDeptId;

    @ApiModelProperty(value = "状态",example = "0")
    private Integer status;


    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
