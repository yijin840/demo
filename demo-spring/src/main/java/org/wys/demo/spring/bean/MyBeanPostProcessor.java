package org.wys.demo.spring.bean;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.wys.demo.spring.config.MyConfiguration;
import org.wys.demo.spring.service.MyService;

import java.util.List;

/**
 * @author wys
 * @date 2021/11/15
 */
@Component
@RequiredArgsConstructor
public class MyBeanPostProcessor implements BeanPostProcessor {

    private final Logger log  = LoggerFactory.getLogger(MyBeanPostProcessor.class);


    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
//        log.info("[postProcessAfterInitialization] bean name ====> {}", beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
