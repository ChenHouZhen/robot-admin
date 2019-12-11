package com.chenhz.server.form.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageForm {

    @ApiModelProperty(value = "当前页",example = "1")
    private Integer page;

    @ApiModelProperty(value = "每页数",example = "1")
    private Integer limit;
}
