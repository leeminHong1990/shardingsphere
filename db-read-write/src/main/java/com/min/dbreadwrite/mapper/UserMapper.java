package com.min.dbreadwrite.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.min.dbreadwrite.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 用户mapper
 *
 * @author xub
 * @date 2019/10/8 下午9:23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */

//    int insert(User record);

    /**
     * 获取所有用户
     */
    List<User> selectAll();

//    int update(User user);

}