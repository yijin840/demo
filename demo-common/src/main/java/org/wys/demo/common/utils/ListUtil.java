package org.wys.demo.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2021/8/20
 */
public class ListUtil {

    /**
     * 获取需要更新的列表
     *
     * @param origin 原数组， 数据库中原来存在的
     * @param target 目标数组
     * @param <T>    类型
     * @return 返回一个同类型数组
     */
    public static <T> List<T> intersection(List<T> origin, List<T> target) {
        if (CollectionUtils.isEmpty(origin) || CollectionUtils.isEmpty(target)) {
            return new ArrayList<>();
        }
        return Lists.newArrayList(Sets.intersection(Sets.newHashSet(origin), Sets.newHashSet(target)));
    }


    /**
     * 原数组和目标数组不相同的数据
     *
     * @param origin 原数组
     * @param target 目标数组
     * @param <T> 类型
     * @return 与原数组不相同的数组
     */
    public static <T> List<T> difference(List<T> origin, List<T> target) {
        if (CollectionUtils.isEmpty(origin) && CollectionUtils.isEmpty(target)) {
            return new ArrayList<>();
        }
        if (CollectionUtils.isEmpty(origin)) {
            return target;
        }
        if (CollectionUtils.isEmpty(target)) {
            return origin;
        }
        return Lists.newArrayList(Sets.difference(Sets.newHashSet(origin), Sets.newHashSet(target)));
    }
}

