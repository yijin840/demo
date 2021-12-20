package org.wys.demo.common.annotation;

import java.lang.annotation.*;

/**
 * @author wys
 * @date 2021/12/20
 * 字典
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Label {

    String name() default "";

    String value() default "";

}
