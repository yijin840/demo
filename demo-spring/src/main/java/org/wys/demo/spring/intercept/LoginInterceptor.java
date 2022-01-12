package org.wys.demo.spring.intercept;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wys.demo.spring.bean.User;
import org.wys.demo.spring.context.UserContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * @author wys
 * @date 2021/12/24
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        User user = new User();
        String username = request.getParameter("username");
        user.setUsername(username);
        UserContext.addUser(user);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    
}
