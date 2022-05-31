package org.wys.demo.spring.cache;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.*;

/**
 * @author wys
 * @date 2022/5/31
 * 缓存bean注解，注入在类上面，缓存当前类对象
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@ComponentScan
public @interface CacheBean {
    @AliasFor("class")
    Class<?> value();

    int time() default 1;

    TimeUnit timeUnit() default TimeUnit.MINUTES;

    boolean enable() default true;

    CacheStrategy strategy() default CacheStrategy.NONE;
}
