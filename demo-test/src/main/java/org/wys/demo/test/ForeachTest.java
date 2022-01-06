package org.wys.demo.test;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wys
 * @date 2022/1/4
 */
public class ForeachTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1,1,2,3");
        list.add("2,214,12,4");
        Map<String, String> map = new HashMap<>(16);
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        IntStream intStream = list.stream().flatMapToInt(item -> Arrays.stream(Arrays.stream(item.split(",")).mapToInt(Integer::new).toArray())).distinct();
        int[] toArray = intStream.toArray();
        for (int s : toArray) {
            System.out.println(s);
        }

    }

}
