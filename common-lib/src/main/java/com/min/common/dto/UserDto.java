package com.min.common.dto;

import lombok.Data;

/**
 * @author min
 */
@Data
public class UserDto extends BaseDto {
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
}
