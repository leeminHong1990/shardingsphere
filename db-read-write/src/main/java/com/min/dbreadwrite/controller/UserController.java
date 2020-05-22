package com.min.dbreadwrite.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.min.common.param.UserParams;
import com.min.dbreadwrite.entity.User;
import com.min.dbreadwrite.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @author min
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 创建用户
     * @param userParams 用户基本信息
     * @return 是否创建成功
     */
    @PostMapping("/users")
    public boolean addUser(@RequestBody UserParams userParams) {
        System.out.println("post mapping users:" + userParams.getUserName());
        User user = User.builder()
                .age(userParams.getAge())
                .userName(userParams.getUserName())
                .sex(userParams.getSex())
                .build();
        userService.saveOne(user);
        return true;
    }

    /**
     * 所有数据
     * @return 所有用户 包含软删除数据 这里使用的是在xml中自定义的方法
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("get mapping users:");
        List<User> userList = userService.list();
        return userList;
    }

    /**
     * 查找未被软删除的数据
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable @NotNull Long id) {
        System.out.println("get user id:" + id);
        User user = userService.selectOne(id);
        return user;
    }

    /** 更新 自动更新 version 和 update_time 字段
     * 用这种方式不会自动更新 update_time字段,因为查出来的数据覆盖了 MyMetaObjectHandler 的fill数据，而又需要version字段所以updateTime加入了 update="now()" (优先级较高)
     * @param userParams 更新信息
     * @return 是否成功更新
     */
    @PutMapping("/users")
    public boolean updateUser(@RequestBody UserParams userParams) {
        System.out.println("update mapping users:" + userParams.getId());
        User user = userService.selectOne(userParams.getId());
        if (null == user) {
            return false;
        }
        user.setAge(userParams.getAge());
        user.setSex(userParams.getSex());
        user.setUserName(userParams.getUserName());
        userService.update(user);
        return true;
    }

    /**
     * 软删除
     * @param id 用户id
     * @return 是否软删除成功
     */
    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable @NotNull Long id) {
        Integer deleteRowCount = userService.delete(id);
        return deleteRowCount == 1;
    }

    /**
     * 简单分页查询 不包含软删除
     * 有bug @Jsonignore 无效，查出的是全表未过滤的列
     * @param age 年龄
     * @param pageNo 第几页 从1开始
     * @param pageSize 每页大小
     * @return 分页信息
     */
    @GetMapping("/users/page")
    public IPage<Map<String, Object>> pageUser(@RequestParam @NotNull Integer age, @RequestParam @NotNull Integer pageNo, @RequestParam @NotNull Integer pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("age", age);

        IPage<Map<String,Object>> page = new Page<>(pageNo,pageSize);

        IPage<Map<String, Object>> mapIPage = userService.selectMapsPage(page, wrapper);

        return mapIPage;
    }
}
