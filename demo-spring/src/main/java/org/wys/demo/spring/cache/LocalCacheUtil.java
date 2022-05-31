package org.wys.demo.spring.cache;

import cn.hutool.core.util.ReflectUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wys
 * @date 2022/5/31
 */
public class LocalCacheUtil {

    /**
     *
     * @param bean
     * @return
     */
    public static CacheStrategy getCacheStrategy(Object bean) {
        Annotation[] annotations = bean.getClass().getAnnotations();
        for(Annotation annotation : annotations) {
            if(annotation.annotationType().getTypeName().equals(CacheBean.class.getTypeName())) {
                Method[] methods = annotation.annotationType().getDeclaredMethods();
                for(Method method : methods) {
                    try {
                        if("strategy".equals(method.getName())) {
                            return (CacheStrategy) method.invoke(annotation);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return CacheStrategy.NONE;
    }

    /**
     *
     * @return
     */
    public static LocalDateTime getDefaultEndTime() {
        return LocalDateTime.now().plusSeconds(10);
    }
}
