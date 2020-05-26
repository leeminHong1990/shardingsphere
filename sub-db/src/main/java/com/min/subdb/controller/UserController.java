package com.min.subdb.controller;

import com.min.common.param.UserParams;
import com.min.subdb.entity.User;
import com.min.subdb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author min
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

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
//        log.info(user.getId().toString());
//        log.info("----------------------");
        userService.saveOne(user);
        return true;
    }
}
