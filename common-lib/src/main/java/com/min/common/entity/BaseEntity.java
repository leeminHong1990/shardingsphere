package com.min.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.min.common.serializable.LongJsonSerializer;
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
    @JsonSerialize(using = LongJsonSerializer.class)
    @TableId
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
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, update = "now()")
    private Date updateTime;

    /**
     * 软删除
     * 字段支持所有数据类型(推荐使用 Integer,Boolean,LocalDateTime)
     * 如果使用LocalDateTime,建议逻辑未删除值设置为字符串null,逻辑删除值只支持数据库函数例如now()
     * 效果: 使用mp自带方法删除和查找都会附带逻辑删除功能 (自己写的xml不会)
     * 实体类上有 @TableLogic 则以实体上的为准，忽略全局application.yml配置。 即先查找注解再查找全局，都没有则此表没有逻辑删除。
     * 逻辑删除是为了方便数据恢复和保护数据本身价值等等的一种方案，但实际就是删除。
     * 如果你需要再查出来就不应使用逻辑删除，而是以一个状态去表示。如： 员工离职，账号被锁定等都应该是一个状态字段，此种场景不应使用逻辑删除。
     */
    @JsonIgnore
    @TableLogic
    private Boolean deleted=false;

    /**
     * 乐观锁
     * 支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime
     * 整数类型下 newVersion = oldVersion + 1
     * newVersion 会回写到 entity 中
     * 仅支持 updateById(id) 与 update(entity, wrapper) 方法
     * 在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
     */
    @Version
    private Integer version=0;
}
