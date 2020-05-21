package com.min.dbreadwrite.controller;

import com.min.common.param.UserParams;
import com.min.dbreadwrite.entity.User;
import com.min.dbreadwrite.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author min
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public boolean addUser(@RequestBody UserParams user) {
        System.out.println("post mapping users:" + user.getName());
        com.min.dbreadwrite.entity.User user1 = com.min.dbreadwrite.entity.User.builder()
                .age(user.getAge())
                .name(user.getName())
                .sex(user.getSex())
                .build();
        userService.saveOne(user1);
        return true;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("get mapping users:");
        List<User> userList = userService.list();
        return userList;
    }

    @GetMapping("/users/{id}")
    public boolean getUser(@PathVariable @NotNull Long id) {
        System.out.println("get user id:" + id);
        return true;
    }

    @PutMapping("/users")
    public boolean updateUser() {
        System.out.println("update mapping users:");
        return true;
    }
}
