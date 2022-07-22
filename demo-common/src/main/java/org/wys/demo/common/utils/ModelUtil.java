package org.wys.demo.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
public class ModelUtil {

    public static void copyProperties(Object origin, Object target) {
        AssertUtil.notNull(origin);
        AssertUtil.notNull(target);
        //解析
        Field[] originFields = origin.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>(originFields.length + targetFields.length);
        for(Field field : originFields) {
            try {
                field.setAccessible(true);
                map.put(field.getName(), field.get(origin));
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        for(Field field : targetFields) {
            if(map.containsKey(field.getName())) {
                try {
                    field.setAccessible(true);
                    if(!Modifier.isFinal(field.getModifiers())) {
                        field.set(target, map.get(field.getName()));
                    }
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
