package com.min.common.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author min
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseParams {
    /**
     * id
     */
    private Long id;

    /**
     * version
     */
    private Integer version;
}
