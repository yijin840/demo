package org.wys.demo.test;


import com.sun.corba.se.impl.naming.pcosnaming.NameServer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.rocketmq.common.namesrv.NamesrvConfig;
import org.apache.rocketmq.namesrv.NamesrvStartup;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author wys
 * @date 2021/11/9
 */
public class PostConstructorMain {

    public static void main(String[] args) {
//        NamesrvStartup.main0(args);
        String s1 = "2021年10期";
        String s2 = "2021年9期";
        LocalDate s1Date = LocalDate.of(getYear(s1), getMonth(s1), 1);
        LocalDate s2Date = LocalDate.of(getYear(s2), getMonth(s2), 1);
        System.out.println(s1Date);
        System.out.println(s2Date);
        System.out.println(s2Date.compareTo(s1Date));

    }

    public static int getYear(String str) {
        return Integer.parseInt(str.substring(0, str.indexOf("年")));
    }

    public static int getMonth(String str) {
        return Integer.parseInt(str.substring(str.indexOf("年") + 1, str.indexOf("期")));
    }

    @Data
    @NoArgsConstructor
    @Component
    public static class Test implements InitializingBean {

        private Map<String, String> map;

        @Override
        public void afterPropertiesSet() throws Exception {
            init();
        }

        @PostConstruct
        private void init() {
            map = new HashMap<>(16);
            map.put("aaa","aaa");
            map.put("bbb","bbb");
            print();
        }

        void print() {
            printMap(map);
        }

        void printMap(Map<String, String> map) {
            map.forEach((key,value) -> {
                System.out.println("=====>" + key + ":" + value);
            });
        }
    }
}