package org.wys.demo.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author wys
 * @date 2021/12/20
 * 字段注解
 * 1、字段类型，注解写在字段上面
 * 2、文档
 * 3、运行时解析
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

    /**
     * @return 名称
     */
    String name() default "";

    @AliasFor("name")
    String value() default "";

}
