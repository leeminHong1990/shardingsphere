package com.min.subtablereadwrite.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.min.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user表
 * @author min
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tab_user")
public class User extends BaseEntity {

    /**
     * 姓名
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;
}