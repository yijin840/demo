package org.wys.demo.spring.listen;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author wys
 * @date 2022/1/6
 */
@Setter
@Getter
public class UserEvent extends ApplicationEvent {

    private String username;
    private String password;

    public UserEvent(Object source) {
        super(source);
    }

    public UserEvent(Object source, String username, String password) {
        super(source);
        this.username = username;
        this.password = password;
    }

}
