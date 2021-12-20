package org.wys.demo.design.template;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wys
 * @date 2021/11/30
 */
public class SimpleOperatorTemplate extends OperatorTemplate {


    private static Map<String, String> map;

    @Override
    public void init() {
        map = new HashMap<>(16);
    }

    @Override
    public void load() {
        map.put("1", "我好");
        map.put("2", "你好");
        map.put("3", "大家好");
    }

    @Override
    public void print() {
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
