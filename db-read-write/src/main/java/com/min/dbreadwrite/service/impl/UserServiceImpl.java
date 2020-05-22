package com.min.dbreadwrite.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.min.dbreadwrite.entity.User;
import com.min.dbreadwrite.mapper.UserMapper;
import com.min.dbreadwrite.service.UserService;
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
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.ge("age", 26);
//        //后面参数false  表示不查询总记录数
//        Page<User> userPage = new Page<>(1, 2, false);
//  /*  IPage<User> iPage = userMapper.selectPage(userPage, queryWrapper);
//    System.out.println("总页数"+iPage.getPages());
//    System.out.println("总记录数"+iPage.getTotal());
//    List<User> records = iPage.getRecords();
//    records.forEach(System.out::println);
//    */
//        IPage<Map<String, Object>> iPage = userMapper.selectMapsPage(userPage, queryWrapper);
//        System.out.println("总页数" + iPage.getPages());
//        System.out.println("总记录数" + iPage.getTotal());
//        List<Map<String, Object>> records = iPage.getRecords();

//        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery();
//        // lambda.likeRight(User::getName, "王").and(qw -> qw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
//        // lambda.likeRight(User::getName, "王").and(qw -> qw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
//        return userMapper.selectOne(lambda.eq(User::getId, id));
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
