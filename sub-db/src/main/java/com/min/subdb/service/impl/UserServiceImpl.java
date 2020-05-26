package com.min.subdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.min.subdb.entity.User;
import com.min.subdb.mapper.UserMapper;
import com.min.subdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author min
 * 用户实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public String saveOne(User user) {
        userMapper.insert(user);
        return "保存成功";
    }

    @Override
    public Integer update(User user) {
        return userMapper.updateById(user);
    }


    @Override
    public User selectOne(Long id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = userMapper.selectOne(queryWrapper.lambda().eq(User::getId, id));
        return user;
    }

    @Override
    public Integer delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<Map<String,Object>> page, Wrapper<User> queryWrapper) {
        return userMapper.selectMapsPage(page, queryWrapper);
    }

}
