package org.wys.demo.spring.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2022/1/6
 */
@Component
public class UserListen implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent event) {
        String username = event.getUsername();
        String password = event.getPassword();

        System.out.println("[ UserListen ] username : " + username + ", password : " + password);
    }
}
