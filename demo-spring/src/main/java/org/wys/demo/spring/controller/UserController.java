package org.wys.demo.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wys.demo.spring.bean.User;
import org.wys.demo.spring.context.UserContext;
import org.wys.demo.thread.RoutingRunnable;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author wys
 * @date 2021/12/23
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(5
            , 5
            , 1
            , TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(5)
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.AbortPolicy());

    @GetMapping("/login")
    public String login(String username) {
        String name = Thread.currentThread().getName();
        System.out.println("login thread name ===> " + name);
        EXECUTOR.submit(RoutingRunnable.run(() -> {
            System.out.println("thread user =====> " + UserContext.getUser());
        }));
        return UserContext.getUser().getUsername();
    }

    @GetMapping("/logout")
    public String logout(String username) {
        UserContext.removeUser();
        return "true";
    }

    @GetMapping("/check")
    public String check(String username) {
        String name = Thread.currentThread().getName();
        User user = UserContext.getUser();
        System.out.println("check info ===> " + user);
        if (Objects.isNull(user)) {
            return "null";
        }
        return "success";
    }

}
