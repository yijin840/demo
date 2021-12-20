package org.wys.demo.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wys
 * @date 2021/7/28
 */
@Component
@Aspect
@Slf4j
public class ApiAop {

    @Pointcut("execution(public * org.wys.demo.spring.aop.test.*.*(..))")
    public void pointcut() {

    }
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println("前置通知");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知");
    }

    @Around("pointcut()")
    public void round(ProceedingJoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        try {
            Object proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("异常======>{}", throwable.getStackTrace());
        } finally {
        }
        System.out.println("环绕通知");
    }
}
