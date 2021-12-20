package org.wys.demo.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.wys.demo.spring.config.MyConfiguration;

/**
 * @author wys
 * @date 2021/11/15
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private final Logger log  = LoggerFactory.getLogger(MyBeanPostProcessor.class);
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("[postProcessBeforeInitialization] bean name ======> {}", beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info("[postProcessAfterInitialization] bean name ====> {}", beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
