package org.wys.demo.spring.cache;

import cn.hutool.core.util.ReflectUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wys
 * @date 2022/5/31
 */
public class LocalCacheUtil {

    public static CacheStrategy getCacheStrategy(Object bean) {
        Annotation[] annotations = bean.getClass().getAnnotations();
        for(Annotation annotation : annotations) {
            if(annotation.annotationType().getTypeName().equals(CacheBean.class.getTypeName())) {
                Method[] methods = annotation.annotationType().getDeclaredMethods();
                for(Method method : methods) {
                    try {
                        Object invoke = method.invoke(annotation);
                        System.out.println(invoke);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return CacheStrategy.LRU;
    }

}
