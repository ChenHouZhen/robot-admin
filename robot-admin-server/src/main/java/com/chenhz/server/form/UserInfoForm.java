package com.chenhz.server.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户查询表单")
public class UserInfoForm {

    @ApiModelProperty(value = "当前页",example = "1")
    private Integer page;

    @ApiModelProperty(value = "每页数",example = "1")
    private Integer limit;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;

    @ApiModelProperty(value = "排序类型")
    private String sortType;

    @ApiModelProperty(value = "状态",example = "1")
    private Integer status;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "部门ID",example = "1")
    private Integer deptId;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
