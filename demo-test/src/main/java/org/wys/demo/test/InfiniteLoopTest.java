package org.wys.demo.test;

import com.google.common.collect.Sets;
import io.swagger.models.auth.In;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * @author wys
 * @date 2022/4/21
 */
public class InfiniteLoopTest {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        l2.add(4);
        Set<Integer> set = Sets.intersection(new HashSet<>(l1), new HashSet<>(l2));
        System.out.println(set);
        new ArrayList<>(5);
    }
    public static <T> List<T> getOrNotList(List<T> list) {
        if(Objects.isNull(list)) {
            return new ArrayList<>();
        }
        return list;
    }
}
