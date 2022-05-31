//package org.wys.demo.spring.cache;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.core.convert.Convert;
//import cn.hutool.core.util.ArrayUtil;
//import cn.hutool.core.util.ClassUtil;
//import cn.hutool.core.util.ReflectUtil;
//import cn.hutool.core.util.StrUtil;
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Array;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * @author wys
// * @date 2022/5/30
// */
//public class CacheUtil {
//
//    private static final Map<Class<?>, Map<String, BeanProperty>> PROPERTIES_CACHE = new ConcurrentHashMap<>();
//
//    /**
//     * 获取属性描述并缓存
//     */
//    private static Map<String, BeanProperty> getPropertyDescriptor(Class<?> clazz) {
//        return PROPERTIES_CACHE.computeIfAbsent(clazz, cls -> {
//            PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(cls);
//            HashMap<String, BeanProperty> map = new HashMap<>(propertyDescriptors.length, 1.0F);
//            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//                BeanProperty beanProperty = new BeanProperty();
//                beanProperty.setName(propertyDescriptor.getName());
//                beanProperty.setPropertyDescriptor(propertyDescriptor);
//                Field field = ReflectUtil.getField(clazz, propertyDescriptor.getName());
//                beanProperty.setField(field);
//                map.put(propertyDescriptor.getName(), beanProperty);
//            }
//            return Collections.unmodifiableMap(map);
//        });
//    }
//
//    private final Map<String, String> propertiesMap = new ConcurrentHashMap<>();
//
//    private final Set<Class<?>> ignoreClass = new CopyOnWriteArraySet<>();
//
//    private final Set<FieldConverter> fieldConverterSet = new CopyOnWriteArraySet<>();
//
//    @Getter
//    private boolean ignoreNull = true;
//
//    public BeanConverter addMapper(String source, String target) {
//        propertiesMap.put(target, source);
//        return this;
//    }
//
//    public BeanConverter addFieldConverter(FieldConverter fieldConverter) {
//        fieldConverterSet.add(fieldConverter);
//        return this;
//    }
//
//    public BeanConverter addFieldConverter(Collection<FieldConverter> fieldConverters) {
//        fieldConverterSet.addAll(fieldConverters);
//        return this;
//    }
//
//    public BeanConverter addFieldConverter(FieldConverter... fieldConverters) {
//        return addFieldConverter(Arrays.asList(fieldConverters));
//    }
//
//    public BeanConverter addNotDeepCopy(Class<?> clazz) {
//        ignoreClass.add(clazz);
//        return this;
//    }
//
//    public BeanConverter ignoreNull(boolean ignoreNull) {
//        this.ignoreNull = ignoreNull;
//        return this;
//    }
//
//
//    public <T, R> R convert(T source, R target) {
//        return convert(source, target, target.getClass());
//    }
//
//    public <T, R> R convert(T source, R target, Class<?> targetClass) {
//        if (null == source) {
//            return null;
//        }
//        Class<?> sourceClass = source.getClass();
//
//        Map<String, BeanProperty> sourceProperties = getPropertyDescriptor(sourceClass);
//        Map<String, BeanProperty> targetProperties = getPropertyDescriptor(targetClass);
//
//        for (BeanProperty targetBeanProperty : targetProperties.values()) {
//            // 获取目标属性描述
//            BeanProperty sourceBeanProperty = getSourceProperty(targetBeanProperty, sourceProperties);
//            if (null == sourceBeanProperty) {
//                continue;
//            }
//
//            // 获取并转化目标属性值
//            Object targetValue = getTargetValue(source, sourceBeanProperty, targetBeanProperty);
//
//            // 忽略空值
//            if (ignoreNull && null == targetValue) {
//                continue;
//            }
//
//            // 写入
//            Method writeMethod = targetBeanProperty.getPropertyDescriptor().getWriteMethod();
//            try {
//                writeMethod.invoke(target, targetValue);
//            } catch (Exception e) {
//                try {
//                    Class<?>[] parameterTypes = writeMethod.getParameterTypes();
//                    if (parameterTypes.length > 0) {
//                        Object convert = Convert.convert(parameterTypes[0], targetValue);
//                        if (null != convert) {
//                            writeMethod.invoke(target, convert);
//                        }
//                    }
//                } catch (Exception ex) {
//                    log.warn(StrUtil.format("write value error, name: {}, source class: {}, target class: {} value: {}",
//                            targetBeanProperty.getName(),
//                            sourceBeanProperty.getPropertyDescriptor().getPropertyType(),
//                            targetBeanProperty.getPropertyDescriptor().getPropertyType(),
//                            targetValue
//                    ), ex);
//                }
//            }
//        }
//        return target;
//    }
//
//    /**
//     * 转化对象
//     */
//    public <T, R> R convert(T source, Class<R> targetClass) {
//        return convert(source, newBean(targetClass), targetClass);
//    }
//
//    /**
//     * 获取并转化目标属性值
//     */
//    private Object getTargetValue(Object source, BeanProperty sourceBeanProperty, BeanProperty targetBeanProperty) {
//        Class<?> targetClass = targetBeanProperty.getPropertyDescriptor().getPropertyType();
//
//        Method readMethod = sourceBeanProperty.getPropertyDescriptor().getReadMethod();
//        Object value = ReflectUtil.invoke(source, readMethod);
//        if (null == value) {
//            return null;
//        }
//
//        //自定义转化器
//        for (FieldConverter fieldConverter : fieldConverterSet) {
//            Object o = fieldConverter.convert(targetBeanProperty, value);
//            if (o != null) {
//                return o;
//            }
//        }
//
//        //不深拷贝对象
//        Class<?> propertyType = targetBeanProperty.getPropertyDescriptor().getPropertyType();
//        boolean isNotDeepCopy = ignoreClass.contains(propertyType) || ClassUtil.isSimpleValueType(propertyType);
//        if (isNotDeepCopy) {
//            return value;
//        }
//
//
//        // 处理集合或数组
//        if (isCollectionOrArray(value.getClass())) {
//            Class<?> elementType = getElementType(targetBeanProperty);
//            if (null == elementType) {
//                return value;
//            }
//            Object targetCollection = newCollectionOrArray(value, targetClass);
//            foreach(value, (data, i) -> add(targetCollection, i, convert(data, elementType)));
//            return targetCollection;
//        }
//
//        // 处理map
//        if (ClassUtil.isAssignable(Map.class, value.getClass())) {
//            log.warn("can not convert: {} to {}", value.getClass(), targetClass);
//            return null;
//        }
//
//        //递归深拷贝对象
//        return convert(value, propertyType);
//    }
//
//    private boolean isCollectionOrArray(Class<?> clazz) {
//        return clazz.isArray() || ClassUtil.isAssignable(Collection.class, clazz);
//    }
//
//    private Class<?> getElementType(BeanProperty beanProperty) {
//        Class<?> propertyType = beanProperty.getPropertyDescriptor().getPropertyType();
//        if (propertyType.isArray()) {
//            return ArrayUtil.getArrayType(propertyType);
//        } else if (ClassUtil.isAssignable(Collection.class, propertyType)) {
//            Type[] actualTypeArguments = beanProperty.getActualTypeArguments();
//            if (null != actualTypeArguments && actualTypeArguments.length > 0) {
//                return (Class<?>) actualTypeArguments[0];
//            }
//            return null;
//        }
//        return null;
//    }
//
//    @SuppressWarnings("all")
//    private <T> T newCollectionOrArray(Object source, Class<T> targetClass) {
//        if (targetClass.isArray()) {
//            return (T) ArrayUtil.newArray(ArrayUtil.getComponentType(targetClass), ArrayUtil.length(source));
//        } else if (ClassUtil.isAssignable(Collection.class, targetClass)) {
//            T target = newBean(targetClass);
//            if (null != target) {
//                return (T) target;
//            }
//            if (ClassUtil.isAssignable(List.class, targetClass)) {
//                return (T) new ArrayList<>();
//            } else if (ClassUtil.isAssignable(Set.class, targetClass)) {
//                return (T) new HashSet();
//            } else if (ClassUtil.isAssignable(Queue.class, targetClass)) {
//                return (T) new LinkedList();
//            }
//        }
//        return null;
//    }
//
//    @SuppressWarnings("all")
//    private void foreach(Object obj, CollUtil.Consumer consumer) {
//        if (null == obj) {
//            return;
//        }
//        if (obj instanceof Collection) {
//            Iterator<?> iterator = ((Collection) obj).iterator();
//            int index = 0;
//            while (iterator.hasNext()) {
//                consumer.accept(iterator.next(), index);
//                index++;
//            }
//        } else if (ArrayUtil.isArray(obj)) {
//            int length = ArrayUtil.length(obj);
//            for (int i = 0; i < length; ++i) {
//                consumer.accept(ArrayUtil.get(obj, i), i);
//            }
//        }
//    }
//
//    @SuppressWarnings("all")
//    private void add(Object obj, int index, Object data) {
//        if (obj instanceof Collection) {
//            ((Collection) obj).add(data);
//        } else if (ArrayUtil.isArray(obj)) {
//            Array.set(obj, index, data);
//        }
//    }
//
//    private <T> T newBean(Class<T> clazz) {
//        try {
//            return clazz.getConstructor().newInstance();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /**
//     * 获取目标属性描述
//     */
//    private BeanProperty getSourceProperty(BeanProperty target, Map<String, BeanProperty> sourceProperties) {
//        String targetName = target.getName();
//        // 自定义匹配
//        String mappedSourceName = propertiesMap.get(targetName);
//        if (StrUtil.isNotBlank(mappedSourceName)) {
//            BeanProperty descriptor = sourceProperties.get(mappedSourceName);
//            if (null != descriptor) {
//                return descriptor;
//            }
//        }
//        return sourceProperties.get(targetName);
//    }
//
//
//}
