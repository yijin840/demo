package org.wys.demo.reflect.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.wys.demo.reflect.proxy.func.ProxyFunction;
import org.wys.demo.reflect.proxy.func.UserProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author wys
 * @date 2022/2/9
 */
public class SimpleCglibProxy {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserProxy.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            return methodProxy.invokeSuper(o, objects);
        });
        UserProxy proxyFunction = (UserProxy) enhancer.create();
        System.out.println(proxyFunction.process("233"));
    }

}
