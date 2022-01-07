package org.wys.demo.test;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wys
 * @date 2021/12/3
 */
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.testMap();
        lambdaTest.testFlatMap();

    }

    public void testFlatMap() {
        GoodLine g1 = new GoodLine("111");
        GoodLine g2 = new GoodLine("222");
        GoodLine g3 = new GoodLine("333");
        GoodLine g4 = new GoodLine("444");
        List<GoodLine> goodLineList1 = Lists.newArrayList(g1,g2);
        List<GoodLine> goodLineList2 = Lists.newArrayList(g3,g4);
        Good gg1 = new Good(goodLineList1);
        Good gg2 = new Good(goodLineList2);

        List<Good> goodList = Lists.newArrayList(gg1,gg2);
        List<GoodLine> goodLines = goodList.stream().map(Good::getGoodLineList).flatMap(Collection::stream).collect(Collectors.toList());
        for (GoodLine goodLine : goodLines) {
            System.out.println(goodLine.name);
        }
    }

    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("b", null);
        System.out.println(map.containsKey("b"));

        A a = new A();
        a.setA("123");
        System.out.println(a.a);
        setA(a);
        System.out.println(a.a);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("aaaa");
        System.out.println(stringBuilder.length());
    }
    public static void setA(A a) {
        a.setA("233");
        System.out.println(a.a);
    }

    @Data
    static class A {
        private String a;
    }

    @Data
    static class Good {
        private List<GoodLine> goodLineList;
        public Good(List<GoodLine> goodLineList) {
            this.goodLineList = goodLineList;
        }
    }

    @Data
    static class GoodLine {
        private String name;
        public GoodLine(String name) {
            this.name = name;
        }
    }
}
