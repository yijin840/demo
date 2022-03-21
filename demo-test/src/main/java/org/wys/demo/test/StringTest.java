package org.wys.demo.test;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wys
 * @date 2022/3/14
 */
public class StringTest {

    public static void main(String[] args) {
        Model m1 = new Model();
        m1.num = 1;
        m1.period = "aaa";

        Model m2 = new Model();
        m2.num = 2;
        m2.period = "aaa";

        Model m3 = new Model();
        m3.num = 3;
        m3.period = "bbb";

        List<Model> modelList = Lists.newArrayList(m1,m2,m3);
        Map<String, List<Model>> stringListMap = modelList.stream().collect(Collectors.groupingBy(Model::getPeriod));
        stringListMap.forEach((key,value)->{
            System.out.println(value);
        });
    }

    @Data
    static class Model {
        String period;
        int num;
    }
}
