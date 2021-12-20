package org.wys.demo.spring.bean;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author wys
 * @date 2021/11/30
 */
@Component
public class MyBeanFactory {

    private Map<String, String> map;

    @PostConstruct
    void init() {
        map = Maps.newHashMap();
        map.put("1", "1");
        map.put("2", "2");

        print();
    }

    public void print() {
        map.forEach((key,value)-> System.out.println(key + ":" + value));
    }



}
