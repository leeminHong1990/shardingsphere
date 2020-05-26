package com.min.subtable.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.min.subtable.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author xub
 * @Description: 用户相关接口
 * @date 2019/8/24 下午6:32
 */
public interface UserService {

    /**
     * 获取所有用户信息
     */
    List<User> list();

    /**
     * 单个 保存用户信息
     *
     * @param user
     */
    String saveOne(User user);

    Integer update(User user);

    User selectOne(Long id);

    Integer delete(Long id);

    IPage<Map<String, Object>> selectMapsPage(IPage<Map<String, Object>> page, Wrapper<User> queryWrapper);
}