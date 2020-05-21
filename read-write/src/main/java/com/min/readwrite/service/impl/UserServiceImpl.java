package com.min.readwrite.service.impl;

import com.min.readwrite.entity.User;
import com.min.readwrite.mapper.UserMapper;
import com.min.readwrite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



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
}
