package com.min.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author min
 */
@Data
public abstract class BaseEntity implements Serializable {
    /**
     * 主键
     */
    @JsonIgnore
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建者
     */
    @JsonIgnore
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 插入时间
     */
    @JsonIgnore
    @TableField(value = "create_time", select = false, fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 软删除
     */
    @JsonIgnore
    @TableLogic
    private Boolean deleted=false;

    /**
     * 版本号
     */
    @JsonIgnore
    @Version
    private Integer version =0;
}
