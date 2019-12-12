package com.chenhz.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件资源表
 * </p>
 *
 * @author chenhz
 * @since 2019-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_file")
public class SysFileEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pId", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * URL地址
     */
    private String url;

    /**
     * 大小,字节
     */
    private Long size;

    /**
     * 0为正常状态，1为删除状态，默认为0
     */
    private Integer status;

    /**
     * 类型，, -1:无法解析，0:图片，1:文件，默认为0
     */
    private Integer type;

    /**
     * 存储位置，0:阿里云，默认为0
     */
    private Integer source;

    /**
     * 文件描述
     */
    private String desc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUser;


}
