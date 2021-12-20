package org.wys.demo.spring.annotations;

import java.lang.annotation.*;

/**
 * @author wys
 * @date 2020/12/22 8:30 下午
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {
    String name() default "";
    int value() default 0;
}
