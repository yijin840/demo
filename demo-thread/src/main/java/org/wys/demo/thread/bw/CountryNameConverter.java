package org.wys.demo.thread.bw;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName CountryNameConverter
 * Package org.wys.demo.thread.bw
 * Description
 *
 * @author wys
 * @date 2022/6/13 17:30
 */

public class CountryNameConverter {

    private static final Map<String, String> map;
    static {
        map = new HashMap<>(16);
        map.put("china","CN");
        map.put("america","US");
        map.put("japan","JP");
        map.put("england","UK");
        map.put("france","FR");
        map.put("germany","DE");
    }

    public String convertByMap(String country) {
        return map.get(country);
    }

    public String convertBySwitch(String fullName) {
        //switch优化
        fullName = fullName.toLowerCase();
        String res;
        switch(fullName) {
            case "china": res = "CN";break;
            case "america": res = "US";break;
            case "japan": res = "JP";break;
            case "england": res = "UK";break;
            case "france": res = "FR";break;
            case "germany": res = "DE";break;
            default: throw new RuntimeException("unknown country");
        }
        return res;
    }
    // 请按你的实际需求修改参数
    public String convertCountryName(String fullName) {
        //Map优化
        return convertByMap(fullName);
        //switch优化
        //return convertBySwitch(fullName);
    }
}