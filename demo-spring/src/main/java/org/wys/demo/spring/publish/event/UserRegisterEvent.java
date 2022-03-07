package org.wys.demo.spring.publish.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author wys
 * @date 2021/9/8
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
