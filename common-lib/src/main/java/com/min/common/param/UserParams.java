package com.min.common.param;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author min
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserParams extends BaseParams {

    @Builder
    public UserParams(Long id, Integer version, String userName, String sex, Integer age) {
        super(id, version);
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }

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
