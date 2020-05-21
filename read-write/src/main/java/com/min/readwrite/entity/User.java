package com.min.readwrite.entity;

import com.min.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;

/**
 * user表
 * @author min
 */
@Data
@Builder
public class User extends BaseEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;


    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}