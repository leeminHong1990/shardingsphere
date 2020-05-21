package com.min.common.param;

import lombok.Data;

import java.util.Date;

/**
 * @author min
 */
@Data
public class UserParams {
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
