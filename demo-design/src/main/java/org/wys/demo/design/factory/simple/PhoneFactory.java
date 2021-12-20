package org.wys.demo.design.factory.simple;

import java.util.Objects;

/**
 * @author wys
 * @date 2020/11/16 10:00 上午
 */
public class PhoneFactory {

    public static Phone getPhone(String name) {

        if (Objects.equals(name, "Iphone")) {
            return new Iphone();
        } else if (Objects.equals(name, "MiPhone")) {
            return new MiPhone();
        }
        return null;
    }
}
