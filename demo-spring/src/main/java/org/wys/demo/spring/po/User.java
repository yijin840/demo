package org.wys.demo.spring.po;

import org.wys.demo.spring.annotations.MyField;
import lombok.Data;

import java.util.Date;

/**
 * @author wys
 * @date 2020/12/22 8:55 下午
 */
@Data
public class User {

    private Long id;

    @MyField(value = 2)
    private String name;

    @MyField(value = 3)
    private int age;

    private Date birthday;

    public User(Long id, String name , Integer age, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    public User() {
    }
}
