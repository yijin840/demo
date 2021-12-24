package org.wys.demo.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wys.demo.spring.bean.User;
import org.wys.demo.spring.context.UserContext;

import java.util.Collections;
import java.util.Objects;

/**
 * @author wys
 * @date 2021/12/23
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/login")
    public String login(String username) {
        String name = Thread.currentThread().getName();
        System.out.println("login thread name ===> " + name);
        User user = new User();
        user.setUsername(username);
        UserContext.addUser(user);
        return UserContext.getUser(username).getUsername();
    }

    @GetMapping("/logout")
    public String logout(String username) {
        UserContext.removeUser();
        return "true";
    }

    @GetMapping("/check")
    public String check(String username) {
        String name = Thread.currentThread().getName();
        User user = UserContext.getUser(username);
        System.out.println("check info ===> " + user);
        if (Objects.isNull(user)) {
            return "null";
        }
        return "success";
    }

}
