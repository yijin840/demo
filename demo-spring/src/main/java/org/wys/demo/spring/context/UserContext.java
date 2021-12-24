package org.wys.demo.spring.context;

import org.wys.demo.spring.bean.User;

import java.util.Map;

/**
 * @author wys
 * @date 2021/12/23
 */
public class UserContext {

    private static final ThreadLocal<User> USER_LOCAL = new ThreadLocal<>();;

    private UserContext() {

    }

    /**
     * 获取当前用户对象
     *
     * @return 当前用户信息
     */
    public static User getUser(String username) {
        return USER_LOCAL.get();
    }

    /**
     * 移除当前用户信息
     */
    public static void removeUser() {
        USER_LOCAL.remove();
    }

    /**
     * 添加用户信息
     *
     * @param user 用户信息
     */
    public static void addUser(User user) {
        USER_LOCAL.set(user);
    }

}
